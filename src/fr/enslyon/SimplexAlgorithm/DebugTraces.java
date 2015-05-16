package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.LinearCombination;

/**
 * Created by quentin on 03/05/15.
 * The traces in debug mode of the simplex algorithm
 */
public class DebugTraces<T> implements PrintTraces<T> {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printDictionary(Dictionary<T> dictionary) {
        for (int j = 0; j < dictionary.size(); j++) {
            this.printDictionaryEntry(dictionary.get(j));
        }
        System.out.println("----------------------");
        this.printObjective(dictionary.getObjective());
    }

    @Override
    public String formatVariable(int variable) {
        return "x_" + variable;
    }

    private void printDictionaryEntry(DictionaryEntry<T> dictionaryEntry) {
        System.out.println(dictionaryEntry.toString());
    }
    private void printObjective(LinearCombination<T> objective) {
        System.out.print("z = ");
        System.out.println(objective.toString());
    }
}
