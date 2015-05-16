package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.LinearCombination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by quentin on 14/04/15.
 * The structure that hold the dictionary
 * The simplex algorithm manipulates it
 */
public class Dictionary<T> {
    private ArrayList<DictionaryEntry<T>> dictionaryEntries;
    private LinearCombination<T> objective;
    private Set<Integer> initialVariables;
    private PrintTraces<T> printer;


    public Dictionary(LinearCombination<T> objective, ArrayList<DictionaryEntry<T>> dictionaryEntries) {
        this.objective = objective;
        this.dictionaryEntries = dictionaryEntries;
        this.buildInitialVariables();
    }
    public void setPrinter(PrintTraces<T> printer) {
        this.printer = printer;
    }
    public PrintTraces<T> printer() {
        return printer;
    }

    public DictionaryEntry<T> get(int j) {
        return this.dictionaryEntries.get(j);
    }
    public LinearCombination<T> getObjective() {
        return this.objective;
    }
    public int size() {
        return this.dictionaryEntries.size();
    }

    public Set<Integer> getInitialVariables() {
        return this.initialVariables;
    }

    //Build the set of initial variables (the variables we want the values - e.g. not the slash variables).
    private void buildInitialVariables() {
        this.initialVariables = new HashSet<Integer>();
        Set<Integer> slashVariables = new HashSet<Integer>();
        for (DictionaryEntry<T> dictionaryEntry : this.dictionaryEntries) {
            slashVariables.add(dictionaryEntry.getVariable());
        }
        for(int v = 0; v < this.objective.getNumberOfTerms() + this.dictionaryEntries.size(); v++) {
            if(!slashVariables.contains(v)) {
                this.initialVariables.add(v);
            }
        }
    }
}