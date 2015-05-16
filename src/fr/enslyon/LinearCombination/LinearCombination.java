package fr.enslyon.LinearCombination;

import fr.enslyon.DivisionRing.DivisionRing;

/**
 * Created by quentin on 14/04/15.
 */
public class LinearCombination<T> extends LinearCombinationBaseWithConstant<T> {
    protected DivisionRing<T> ring;

    public LinearCombination(int numberOfTerms, int maximumIndexVariables, DivisionRing<T> ring)
            throws LinearCombinationException {
        super(numberOfTerms, maximumIndexVariables);
        this.ring = ring;
    }

    public LinearCombination(LinearCombination<T> l)
            throws LinearCombinationException {
        super(l);
        this.ring = l.getRing();
    }

    DivisionRing<T> getRing() {
        return this.ring;
    }

    public void scalarMultiplication(T scalar) {
        this.setConstant(this.ring.prod(this.getConstant(), scalar));
        for(int i = 0; i < this.numberOfTerms; i++) {
            this.constantsLinearCombination[i] = this.ring.prod(this.constantsLinearCombination[i], scalar);
        }
    }

    public void add(LinearCombination<T> toAdd) {
        this.setConstant(this.ring.add(this.getConstant(), toAdd.getConstant()));

        for(int i = 0; i < this.numberOfTerms; i++) {
            int indexToAdd = toAdd.getIndexVariable(this.getVariableById(i));

            this.constantsLinearCombination[i] = this.ring.add(this.getConstantById(i),
                        toAdd.getConstantById(indexToAdd));
        }
    }



    public void substitute(DictionaryEntry<T> toSubstitute) throws LinearCombinationException {
        //We substitute all the occurrences of the variable of toSubstitute by the corresponding value in
        // this current object.
        //The corresponding value is:
        // entry.get_constant() +
        // scalar_product(toSubstitute.get_constants_linear_combination(),
        //                toSubstitute.getVariablesLinearCombination())

        int currentIndexToSubstitute = this.getIndexVariable(toSubstitute.getVariable());

        if(currentIndexToSubstitute == -1) {
            throw new LinearCombinationException("The variable " + toSubstitute.getVariable() +
                    "does not appears in the linear combination. Impossible to substitute it");
        }
        else {
            T cstSubstitution = this.constantsLinearCombination[currentIndexToSubstitute];
            //this.constant += cstSubstitution * toSubstitute.getConstant(); :
            this.setConstant(this.ring.add(this.ring.prod(cstSubstitution, toSubstitute.getConstant()),
                                           this.getConstant()));


            for (int i = 0; i < this.numberOfTerms; i++) {
                //i is an index of toSubstitute

                int v = toSubstitute.getVariableById(i);
                int current_index_v= this.getIndexVariable(v);

                if(current_index_v != -1) {
                    //this.constantsLinearCombination[current_index_v] +=
                    //        cstSubstitution * toSubstitute.getConstantsLinearCombination()[i]; :

                    this.constantsLinearCombination[current_index_v] = this.ring.add(
                            this.constantsLinearCombination[current_index_v],
                            this.ring.prod(cstSubstitution, toSubstitute.getConstantById(i)));
                }
                else {
                    //the variable v does not appears in the current equation
                    //we replace in the current entry the variable toSubsistute.get_variable by v

                    //int old_v = this.variablesLinearCombination[currentIndexToSubstitute];
                    int old_v = toSubstitute.getVariable();
                    this.variablesLinearCombination[currentIndexToSubstitute] = v;

                    this.reverseVariables[old_v] = -1;
                    this.reverseVariables[v] = currentIndexToSubstitute;


                    //this.constantsLinearCombination[currentIndexToSubstitute] =
                    //        cstSubstitution * toSubstitute.getConstantsLinearCombination()[i];
                    this.constantsLinearCombination[currentIndexToSubstitute] = this.ring.prod(cstSubstitution,
                            toSubstitute.getConstantById(i));
                }
            }
        }

    }

}
