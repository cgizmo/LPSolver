package fr.enslyon;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.LinearCombination.DictionaryEntryException;
import fr.enslyon.LinearCombination.LinearCombinationException;
import fr.enslyon.Parser.LinearProgram;
import fr.enslyon.SimplexAlgorithm.*;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by quentin on 21/04/15.
 * A class that contains all the parsed data, that called the solver and the printer
 */


public class SimplexEncapsulation<T> {

    private SimplexPrinter<T> printer;

    private boolean isObjectiveMaximize = true;

    private HashSet<String> variables;

    private HashMap<String, Integer> variablesIndex = new HashMap<String, Integer>();
    private HashMap<String, String> composedVariables = new HashMap<String, String>();
    private Dictionary<T> dictionary;
    private LinearProgram<T> linearProgram;

    private DivisionRing<T> ring;

    public SimplexEncapsulation(DivisionRing<T> ring) {
        this.ring = ring;
    }


    public void setDebug() {
        this.dictionary.setPrinter(new DebugTraces<T>());
        this.printer = new SimplexDebugPrinter<T>(isObjectiveMaximize, ring, variables,
                variablesIndex, composedVariables);
    }
    public void setLatex() {
        this.dictionary.setPrinter(new LatexTraces<T>());
        this.printer = new SimplexLatexPrinter<T>(isObjectiveMaximize, ring, variables,
                variablesIndex, composedVariables);
    }
    public void setNormal() {
        this.dictionary.setPrinter(new NoTraces<T>());
        this.printer = new SimplexNormalPrinter<T>(isObjectiveMaximize, ring, variables,
                variablesIndex, composedVariables);
    }

    public void setMinimizeObjective() {
        this.isObjectiveMaximize = false;
    }

    public void setVariables(HashSet<String> variables) {
        this.variables = variables;
    }
    public void addVariableAssociation(String var, Integer index) {
        variablesIndex.put(var, index);
    }
    public HashMap<String, Integer> getVariablesIndex() {
        return this.variablesIndex;
    }

    public void setDictionary(Dictionary<T> dictionary) {
        this.dictionary = dictionary;
    }

    public void setLinearProgram(LinearProgram<T> lp) {
        this.linearProgram = lp;
    }

    public void solve() throws LinearCombinationException, DictionaryEntryException {
        printer.printHeader();
        printer.printLinearProgram(linearProgram);

        Simplex<T> simplex = new Simplex<T>(this.dictionary, ring);
        SimplexOutput<T> solution = simplex.solve();

        printer.printSolution(solution);
        printer.printFooter();
    }

    /*
        The unbounded variable a is set to be equal to a-b
        with a >=0 and b >= 0
     */
    public void addUnboundedVariable(String a, String b) {
        this.composedVariables.put(a, b);
    }
}
