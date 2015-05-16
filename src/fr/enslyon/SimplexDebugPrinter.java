package fr.enslyon;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.LinearProgram;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by quentin on 03/05/15.
 * The output for the debug mode
 */
public class SimplexDebugPrinter<T> extends SimplexNormalPrinter<T> {
    public SimplexDebugPrinter(boolean isObjectiveMaximize, DivisionRing<T> ring, HashSet<String> variables,
                               HashMap<String, Integer> variablesIndex, HashMap<String, String> composedVariables) {
        super(isObjectiveMaximize, ring, variables, variablesIndex, composedVariables);
    }

    @Override
    public void printLinearProgram(LinearProgram<T> linearProgram) {
        printStream.println(linearProgram.toString() + "\n");
        printStream.println("Variable assignations:");
        printStream.println(variablesIndex.toString() + "\n");
    }
}
