package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 04/05/15.
 */
public class LinearCombinationBaseAddAndRemoveVariables<T> extends LinearCombinationBaseWithDirectVariableAccess<T> {
    LinearCombinationBaseAddAndRemoveVariables(int numberOfTerms, int maximumIndexVariables)
            throws LinearCombinationException {
        super(numberOfTerms, maximumIndexVariables);
    }

    LinearCombinationBaseAddAndRemoveVariables(LinearCombinationBaseWithDirectVariableAccess<T> l)
            throws LinearCombinationException {
        super(l);
    }

    public int addVariable(T constantAssociated) {
        int[] variables = new int[this.numberOfTerms+1];
        @SuppressWarnings("unchecked")
        T[] constants = (T[]) new Object[this.numberOfTerms+1];

        System.arraycopy(this.variablesLinearCombination, 0, variables, 0, this.numberOfTerms);
        System.arraycopy(this.constantsLinearCombination, 0, constants, 0, this.numberOfTerms);

        variables[this.numberOfTerms] = this.maximumIndexVariables;
        constants[this.numberOfTerms] = constantAssociated;

        this.numberOfTerms += 1;
        this.maximumIndexVariables += 1;

        this.variablesLinearCombination = variables;
        this.constantsLinearCombination = constants;

        this.buildReverseVariables();

        return this.maximumIndexVariables-1;

    }

    public void removeVariable(int variable) {
        int[] variables = new int[this.numberOfTerms-1];
        @SuppressWarnings("unchecked")
        T[] constants = (T[]) new Object[this.numberOfTerms-1];
        int j = 0;
        for(int i = 0; i < this.numberOfTerms; i++) {
            if(this.variablesLinearCombination[i] != variable) {
                variables[j] = this.variablesLinearCombination[i];
                constants[j] = this.constantsLinearCombination[i];
                j++;
            }
        }
        this.numberOfTerms--;
        this.variablesLinearCombination = variables;
        this.constantsLinearCombination = constants;

        this.buildReverseVariables();
    }
}
