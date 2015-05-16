package fr.enslyon.Parser;

/**
 * Created by quentin on 17/04/15.
 */
public class Bound<T> {
    private String variable;
    private T lower; private T upper;
    private boolean hasLower = false;
    private boolean hasUpper = false;

    Bound(String variable) {
        this.variable = variable;
    }
    public void setLowerBound(T bound) {
        this.lower = bound;
        hasLower = true;
    }
    public void setUpperBound(T bound) {
        this.upper = bound;
        hasUpper = true;
    }

    public boolean hasUpperBound() {
        return hasUpper;
    }
    public T getUpperBound() {
        return upper;
    }
    public boolean hasLowerBound() {
        return hasLower;
    }
    public T getLowerBound() {
        return lower;
    }
    public String getVariable() {
        return variable;
    }
    public String toString() {
        String r = "";
        if(this.hasLower) {
            r = lower.toString() + " <= ";
        }
        r += variable;
        if(this.hasUpper) {
            r += " <= " + upper.toString();
        }
        return r;
    }

}
