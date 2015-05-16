package fr.enslyon.Parser;

import fr.enslyon.DivisionRing.DivisionRing;

/**
 * Created by quentin on 16/04/15.
 */
public class Objective<T> {
    private Boolean isMaximize;
    private SyntacticLinearCombination<T> objective;
    private DivisionRing<T> ring;

    Objective(DivisionRing<T> ring, Boolean isMaximize, SyntacticLinearCombination<T> objective) {
        this.isMaximize = isMaximize;
        this.ring = ring;
        this.objective = objective;
    }

    public SyntacticLinearCombination<T> getObjective() {
        return objective;
    }

    public boolean isObjectiveMaximize() {
        return isMaximize;
    }
    public void setObjectiveToMaximize() {
        isMaximize = true;
    }
    public String toString() {
        String output;
        if(isMaximize)
            output = "MAXIMIZE\n";
        else
            output = "MINIMIZE\n";
        output += objective.toString();
        return output;
    }
}
