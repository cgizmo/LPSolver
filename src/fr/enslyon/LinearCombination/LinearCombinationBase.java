package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 14/04/15.
 */

public class LinearCombinationBase<T> {
    protected int numberOfTerms; //number of different terms in the equation
    protected int maximumIndexVariables; //the total number of variables is maximumIndexVariables
    protected int[] variablesLinearCombination;
    protected T[] constantsLinearCombination;


    LinearCombinationBase(int numberOfTerms, int maximumIndexVariables) throws LinearCombinationException {
        if(numberOfTerms <= 0) {
            throw new LinearCombinationException("the parameter numberOfTerms should be positive");
        }
        else if (numberOfTerms > maximumIndexVariables) {
            throw new LinearCombinationException("the parameter maximumIndexVariables should be greater " +
                    "than numberOfTerms");
        }
        else {
            this.numberOfTerms = numberOfTerms;
            this.maximumIndexVariables = maximumIndexVariables;
        }
    }
    LinearCombinationBase(LinearCombinationBase<T> l) throws LinearCombinationException {
        this(l.getNumberOfTerms(), l.getMaximumIndexVariables());

        int[] variables = new int[l.getNumberOfTerms()];
        @SuppressWarnings("unchecked")
        T[] constants = ( T[]) new Object[l.getNumberOfTerms()];

        for(int i = 0; i < l.getNumberOfTerms(); i++) {
            variables[i] = l.getVariableById(i);
            constants[i] = l.getConstantById(i);
        }

        this.setVariables(variables);
        this.setConstants(constants);

    }

    public void setVariables(int[] variables) throws LinearCombinationException {
        if(variables.length != this.numberOfTerms) {
            throw new LinearCombinationException("the size of the array of the variables should be equal to " +
                    "numberOfTerms");
        }
        else {
            this.variablesLinearCombination = variables;
        }
    }
    public void setConstants(T[] constants) throws LinearCombinationException {
        if(constants.length != this.numberOfTerms) {
            throw new LinearCombinationException("the size of the array of the constants should be equal to " +
                    "numberOfTerms");
        }
        else {
            this.constantsLinearCombination = constants;
        }
    }

    public int getMaximumIndexVariables() {
        return this.maximumIndexVariables;
    }
    public int getNumberOfTerms() {
        return this.numberOfTerms;
    }

    public T getConstantById(int id) {
        return this.constantsLinearCombination[id];
    }
    public int getVariableById(int id) {
        return this.variablesLinearCombination[id];
    }


    public String toString() {
        String output = "";
        for(int i = 0; i < numberOfTerms; i++) {
            if(i > 0)
                output += " + ";
            output += String.format("%s * x_%d",
                    this.constantsLinearCombination[i].toString(), this.variablesLinearCombination[i]);
        }
        return output;
    }
}