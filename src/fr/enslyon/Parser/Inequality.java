package fr.enslyon.Parser;

import fr.enslyon.DivisionRing.DivisionRing;

/**
 * Created by quentin on 16/04/15.
 */
public class Inequality<T> {
    SyntacticLinearCombination<T> combination;
    T constant;
    Boolean greater;
    DivisionRing<T> ring;
    Inequality(DivisionRing<T> ring, SyntacticLinearCombination<T> combination, Boolean greater, T constant) {
        this.combination = combination;
        this.greater = greater;
        this.constant = constant;
        this.ring = ring;
    }
    public SyntacticLinearCombination<T> getCombination() {
        return combination;
    }
    public T getConstant() {
        return constant;
    }
    public void setConstant(T c) {
        constant = c;
    }
    public void scalarMultiplication(T scalar) {
        combination.scalarMultiplication(scalar);
        constant = ring.prod(constant, scalar);
        if(ring.compare(scalar, ring.fromInteger(0)) < 0) {
            greater = !greater;
        }
    }
    public Boolean isGreaterInequality() {
        return greater;
    }

    public void setLessInequality() {
        greater = false;
    }

    public void makeUniformConstant() {
        T nc = ring.add(this.getConstant(), ring.opposite(this.getCombination().getConstant()));
        this.setConstant(nc);
        this.getCombination().setConstant(ring.fromInteger(0));
    }

    /*
    Replace var by var + a
    */
    public void translateVariable(String var, T a) {
        if(combination.containsVariable(var)) {
            combination.translateVariable(var, a);
            this.makeUniformConstant();
        }
    }


    public String toString() {
        String output = combination.toString();
        if(greater) {
            output += " >= ";
        }
        else {
            output += " <= ";
        }
        output += constant.toString();
        return output;
    }

}
