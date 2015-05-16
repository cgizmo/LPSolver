package fr.enslyon;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.LinearProgram;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by quentin on 03/05/15.
 * The output for the latex mode
 */
public class SimplexLatexPrinter<T> extends SimplexPrinter<T> {
    public SimplexLatexPrinter(boolean isObjectiveMaximize, DivisionRing<T> ring, HashSet<String> variables,
                               HashMap<String, Integer> variablesIndex, HashMap<String, String> composedVariables) {
        super(isObjectiveMaximize, ring, variables, variablesIndex, composedVariables);
    }

    @Override
    public void printHeader() {
        printStream.println("\\documentclass[10pt, landscape]{article}");
        printStream.println("\\usepackage[margin=0.5cm]{geometry}");
        printStream.println("\\begin{document}");
    }

    @Override
    public void printFooter() {
        printStream.println("\\end{document}");
    }

    @Override
    public void printLinearProgram(LinearProgram<T> linearProgram) {

    }

    @Override
    public void printMessage(String m) {
        printStream.println(m + " \\newline");
    }
}
