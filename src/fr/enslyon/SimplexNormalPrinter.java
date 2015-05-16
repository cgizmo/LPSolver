package fr.enslyon;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.LinearProgram;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by quentin on 03/05/15.
 * The output in the normal mode
 */
public class SimplexNormalPrinter<T> extends SimplexPrinter<T> {
    public SimplexNormalPrinter(boolean isObjectiveMaximize, DivisionRing<T> ring, HashSet<String> variables,
                                HashMap<String, Integer> variablesIndex, HashMap<String, String> composedVariables) {
        super(isObjectiveMaximize, ring, variables, variablesIndex, composedVariables);
    }

    @Override
    public void printHeader() {

    }

    @Override
    public void printFooter() {

    }

    @Override
    public void printLinearProgram(LinearProgram<T> linearProgram) {

    }

    @Override
    public void printMessage(String m) {
        printStream.println(m);
    }

}
