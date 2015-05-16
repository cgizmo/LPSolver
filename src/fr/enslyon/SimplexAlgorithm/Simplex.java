package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.DictionaryEntryException;
import fr.enslyon.LinearCombination.LinearCombination;
import fr.enslyon.LinearCombination.LinearCombinationException;

import java.util.ArrayList;

/**
 * Created by quentin on 14/04/15.
 * The general simplex algorithm.
 * Here is implemented the auxiliary l.p., the resolution and the projection of the dictionary.
 */
public class Simplex<T> extends SimplexBase<T> {
    public Simplex(Dictionary<T> dictionary, DivisionRing<T> ring) {
        super(dictionary, ring);
    }
    public Simplex(LinearCombination<T> objective, ArrayList<DictionaryEntry<T>> dictionaryEntries, DivisionRing<T> ring) {
        super(objective, dictionaryEntries, ring);
    }

    public SimplexOutput<T> solve() throws DictionaryEntryException, LinearCombinationException {
        if (!this.checkConstantsPositivity()) {
            //We do a copy of the objective before modifying it
            LinearCombination<T> previousObjective = new LinearCombination<T>(this.dictionary.getObjective());
            int variableAdded = this.addNewVariablesSetToOne();
            SimplexOutput<T> auxiliarySolution = this.solveAuxiliaryLP(variableAdded);

            if(auxiliarySolution instanceof OptimalSolution) {
                if(ring.compare(((OptimalSolution<T>) auxiliarySolution).getValue(), ring.fromInteger(0)) != 0)
                    return new EmptyDomain<T>();
                else {
                    this.dictionaryProjection(variableAdded, previousObjective);
                }
            }
            else {
                return new EmptyDomain<T>();
            }

        }
        return super.solve();
    }

    private SimplexOutput<T> solveAuxiliaryLP(int variableAdded)
            throws DictionaryEntryException, LinearCombinationException {

        this.newObjective();

        this.dictionary.printer().printMessage("New objective, new dictionary:");
        this.dictionary.printer().printDictionary(dictionary);

        this.dictionary.printer().printMessage("First illegal pivot:");
        this.fistIllegalPivot(variableAdded);

        return this.solve();
    }

    public SimplexOutput<T> computeAVertex() throws DictionaryEntryException, LinearCombinationException {
        int variableAdded = this.addNewVariablesSetToOne();
        return this.solveAuxiliaryLP(variableAdded);
    }


    //Add a variable in each dictionary set to 1 (during the first phase of the simplex,
    // when we try to find a point in the domain)
    private int addNewVariablesSetToOne() throws DictionaryEntryException {
        int v = this.dictionary.getObjective().addVariable(ring.fromInteger(-1));
        this.dictionary.printer().printMessage("Adding variable " + this.dictionary.printer().formatVariable(v));
        for(int j = 0; j < this.dictionary.size(); j++) {
            int vj = this.dictionary.get(j).addVariable(ring.fromInteger(1));
            if(vj != v) {
                throw new DictionaryEntryException("Dimension problem when trying to add a variable: "
                        + "the dictionary and the objective do not have the same dimension");
            }
        }
        return v;
    }

    // Set the new objective the z = -x_{n-1}
    private void newObjective() throws LinearCombinationException {
        @SuppressWarnings("unchecked")
        T[] newObjectiveConstants = (T[]) new Object[this.dictionary.getObjective().getNumberOfTerms()];
        for(int i = 0; i < newObjectiveConstants.length-1; i++) {
            newObjectiveConstants[i] = ring.fromInteger(0);
        }
        newObjectiveConstants[newObjectiveConstants.length-1] = ring.fromInteger(-1);
        this.dictionary.getObjective().setConstants(newObjectiveConstants);
    }

    private void fistIllegalPivot(int v) throws LinearCombinationException {
        int i = 0;
        T cst = this.dictionary.get(i).getConstant();

        for(int j = 1; j < this.dictionary.size(); j++) {
            if(ring.compare(dictionary.get(j).getConstant(), cst) < 0) {
                i = j;
                cst = dictionary.get(j).getConstant();
            }
        }
        this.pivot(v, i);
    }

    private void dictionaryProjection(int v, LinearCombination<T> previousObjective)
            throws LinearCombinationException {

        //We remove the variable added for each entry.

        /*
        We check that there is no equation of the form:
            x_v = ... in the dictionary
         */
        int indexVAsSlashVariable = -1;
        for(int j = 0; j < this.dictionary.size(); j++) {
            if(this.dictionary.get(j).getVariable() == v) {
                indexVAsSlashVariable = j;
                break;
            }
        }
        //If it is the case:
        if(indexVAsSlashVariable >= 0) {
            boolean found = false;
            for(int i = 0; i < this.dictionary.getObjective().getNumberOfTerms(); i++) {
                T coefficient = dictionary.get(indexVAsSlashVariable).getConstantById(i);
                if(ring.compare(coefficient, ring.fromInteger(0)) != 0) {
                    int variable = dictionary.get(indexVAsSlashVariable).getVariableById(i);
                    this.pivot(variable, indexVAsSlashVariable);
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.printf("Warning!: equation of the form x_%d = 0\n", v);
            }
        }


        for(int j = 0; j < this.dictionary.size(); j++) {
            this.dictionary.get(j).removeVariable(v);
        }
        this.dictionary.getObjective().removeVariable(v);


        this.dictionary.getObjective().setConstant(previousObjective.getConstant());

        for(int i = 0; i < this.dictionary.getObjective().getNumberOfTerms(); i++) {
            int variable = previousObjective.getVariableById(i);
            T scalar = previousObjective.getConstantById(i);

            int indexDictionary = this.getIndexDictionary(variable);
            if(indexDictionary >= 0) {
                LinearCombination<T> l = new LinearCombination<T>(this.dictionary.get(indexDictionary));
                l.scalarMultiplication(scalar);
                this.dictionary.getObjective().add(l);
            }
            else {
                T previousValue = this.dictionary.getObjective().getVariable(variable);
                this.dictionary.getObjective().setVariable(variable, ring.add(previousValue, scalar));
            }
        }

        this.dictionary.printer().printMessage("New objective:");
        this.dictionary.printer().printDictionary(dictionary);
    }

    private int getIndexDictionary(int variable) {
        for(int j = 0; j < this.dictionary.size(); j++) {
            if(this.dictionary.get(j).getVariable() == variable)
                return j;
        }
        return -1;
    }
}