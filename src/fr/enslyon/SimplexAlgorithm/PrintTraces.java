package fr.enslyon.SimplexAlgorithm;

/**
 * Created by quentin on 03/05/15.
 */
public interface PrintTraces<T> {
    public void printMessage(String message);
    public void printDictionary(Dictionary<T> dictionary);
    public String formatVariable(int variable);
}
