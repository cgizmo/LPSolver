package fr.enslyon.LinearCombination;

/**
 * Created by quentin on 25/03/15.
 */
public class DictionaryEntryException extends Exception {
    public DictionaryEntryException(String msg) {
        System.err.println("Error with DictionaryEntry: " + msg);
    }
}
