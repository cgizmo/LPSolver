package fr.enslyon.LinearCombination;

import fr.enslyon.DivisionRing.DivisionRing;

/**
 * Created by quentin on 14/04/15.
 */
public class DictionaryEntry<T> extends LinearCombination<T> {
    private int variable; // in [|0, maximumIndexVariables-1|], variable involved in the equation

    public DictionaryEntry(int numberOfTerms, int maximumIndexVariables, DivisionRing<T> ring, int variable)
            throws DictionaryEntryException, LinearCombinationException
    {
        super(numberOfTerms, maximumIndexVariables, ring);

        if (variable < 0 || variable >= maximumIndexVariables) {
            throw new DictionaryEntryException("the variable associated should be in the range " +
                    "[0, maximumIndexVariables-1]");
        }
        else {
            this.variable = variable;
        }
    }
    public DictionaryEntry(LinearCombination<T> l, int variable) throws LinearCombinationException {
        super(l);
        this.variable = variable;
    }

    public int getVariable() {
        return variable;
    }

    public String toString() {
        return String.format("x_%d = %s", this.variable, super.toString());
    }

    public void swap_variable(int variable) {
        int index_variable = this.getIndexVariable(variable);
        T  c_variable = this.constantsLinearCombination[index_variable];

        // new value for the constant : -constant / c_variable
        this.setConstant(this.ring.prod(this.ring.inverse(this.ring.opposite(c_variable)), this.constant));


        this.variablesLinearCombination[index_variable] = this.variable;
        this.constantsLinearCombination[index_variable] = this.ring.fromInteger(-1);
        this.reverseVariables[variable] = -1;
        this.reverseVariables[this.variable] = index_variable;

        this.variable = variable;

        for(int i = 0; i < numberOfTerms; i++) {
            //this.constantsLinearCombination[i] /= -c_variable :
            this.constantsLinearCombination[i] = this.ring.prod(this.constantsLinearCombination[i],
                    this.ring.inverse(this.ring.opposite(c_variable)));
        }
    }
}
