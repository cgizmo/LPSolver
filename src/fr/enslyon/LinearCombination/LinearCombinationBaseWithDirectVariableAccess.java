package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 04/05/15.
 */
public class LinearCombinationBaseWithDirectVariableAccess<T> extends LinearCombinationBase<T> {
    protected int[] reverseVariables;

    LinearCombinationBaseWithDirectVariableAccess(int numberOfTerms, int maximumIndexVariables)
            throws LinearCombinationException {
        super(numberOfTerms, maximumIndexVariables);
    }

    LinearCombinationBaseWithDirectVariableAccess(LinearCombinationBaseWithDirectVariableAccess<T> l)
            throws LinearCombinationException {
        super(l);
        this.buildReverseVariables();
    }
    public int getIndexVariable(int v) {
        return this.reverseVariables[v];
    }

    public void setVariable(int variable, T value) {
        int indexVariable = this.getIndexVariable(variable);
        this.constantsLinearCombination[indexVariable] = value;
    }

    public T getVariable(int variable) {
        int indexVariable = this.getIndexVariable(variable);
        return this.constantsLinearCombination[indexVariable];
    }


    protected void buildReverseVariables() {
        //build the array this.reverseVariables such that:
        //this.reverseVariables[v] = i with this.variablesLinearCombination[i] = v if i >= 0
        //this.reverseVariables[v] = -1 otherwise

        this.reverseVariables = new int[this.maximumIndexVariables];
        for(int v = 0; v < this.maximumIndexVariables; v++) {
            this.reverseVariables[v] = -1;
        }

        for(int i = 0; i < this.numberOfTerms; i++) {
            this.reverseVariables[this.variablesLinearCombination[i]] = i;
        }
    }

    public void setVariables(int[] variables) throws LinearCombinationException {
        super.setVariables(variables);
        this.buildReverseVariables();
    }
}
