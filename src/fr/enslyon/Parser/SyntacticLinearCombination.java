package fr.enslyon.Parser;

import fr.enslyon.DivisionRing.DivisionRing;

import java.util.HashMap;

/**
 * Created by quentin on 16/04/15.
 */
public class SyntacticLinearCombination<T> {
    private HashMap<String, T> combination;
    private DivisionRing<T> ring;

    SyntacticLinearCombination(DivisionRing<T> ring) {
        combination = new HashMap<String, T>();
        this.ring = ring;
    }

    public void setVariable(String var, T cstAssociated) {
        combination.put(var, cstAssociated);
    }
    public void setConstant(T cstAssociated) {
        setVariable("", cstAssociated);
    }


    public void setOrUpdateVariable(String var, T cstAssociated) {
        if(combination.containsKey(var)) {
            combination.put(var, ring.add(cstAssociated, this.getVariable(var)));
        }
        else {
            combination.put(var, cstAssociated);
        }
    }

    public T getConstant() {
        if(combination.containsKey("")) {
            return combination.get("");
        }
        else {
            return ring.fromInteger(0);
        }
    }
    public void setOrUpdateConstant(T c) {
        setOrUpdateVariable("", c);
    }
    public T getVariable(String var) {
        return combination.get(var);
    }

    public void scalarMultiplication(T scalar) {
        for(String key: combination.keySet()) {
            T newValue = ring.prod(combination.get(key), scalar);
            combination.put(key, newValue);
        }
    }

    public boolean containsVariable(String var) {
        return combination.containsKey(var);
    }
    /*
        Replace var by var + a
     */
    public void translateVariable(String var, T a) {
        if(this.containsVariable(var)) {
            T v = ring.prod(this.getVariable(var), a);
            this.setConstant(ring.add(this.getConstant(), v));
        }
    }

    public String toString() {
        String output = "";
        if(combination.containsKey("") && ring.compare(combination.get(""), ring.fromInteger(0)) != 0) {
            output += combination.get("").toString();
        }
        for(String var: combination.keySet()) {
            if(!var.equals("")) {
                if(!output.equals("")) {
                    output += " + ";
                }
                if(ring.compare(combination.get(var), ring.fromInteger(1)) == 0) {
                    output += var;
                }
                else if(ring.compare(combination.get(var), ring.fromInteger(-1)) == 0) {
                    output += String.format("-%s", var);
                }
                else {
                    output += String.format("%s %s", combination.get(var).toString(), var);
                }
            }
        }
        return output;
    }
}
