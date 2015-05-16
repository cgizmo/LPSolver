package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 30/03/15.
 */
public class LinearCombinationException extends Exception {
    public LinearCombinationException (String msg) {
        System.err.println("Error with DictionaryEntry: " + msg);
    }
}
