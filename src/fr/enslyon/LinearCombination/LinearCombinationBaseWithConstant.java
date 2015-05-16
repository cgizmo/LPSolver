package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 02/05/15.
 */
public class LinearCombinationBaseWithConstant<T> extends LinearCombinationBaseAddAndRemoveVariables<T> {
    protected  T constant;

    LinearCombinationBaseWithConstant(int numberOfTerms, int maximumIndexVariables) throws LinearCombinationException {
        super(numberOfTerms, maximumIndexVariables);
    }

    LinearCombinationBaseWithConstant(LinearCombinationBaseWithConstant<T> l) throws LinearCombinationException {
        super(l);
        this.setConstant(l.getConstant());

    }
    public T getConstant() {
        return this.constant;
    }
    public void setConstant(T constant) {
        this.constant = constant;
    }

    public String toString() {
        return String.format("%s + %s", constant.toString(), super.toString());
    }

}
