package fr.enslyon.Parser;

/**
 * Created by quentin on 17/04/15.
 */
public class Item<T> {
    T constant;
    String variable;
    Item(T c) {
        this("", c);
    }
    Item(String v, T c) {
        this.variable = v;
        this.constant = c;
    }
    public T getConstant() {
        return constant;
    }
    public String getVariable() {
        return variable;
    }
    public void setConstant(T c) {
        this.constant = c;
    }
    public Boolean isConstant() {
        return this.variable.equals("");
    }
    public String toString() {
        return String.format("%s: %s", variable, constant.toString());
    }
}
