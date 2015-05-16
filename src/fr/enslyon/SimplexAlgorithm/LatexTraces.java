package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.LinearCombination;

/**
 * Created by quentin on 03/05/15.
 * The traces of the simplex algorithm for the latex output
 */
public class LatexTraces<T> implements PrintTraces<T> {
    @Override
    public void printMessage(String message) {
        System.out.println(message + " \\newline");
    }

    @Override
    public void printDictionary(Dictionary<T> dictionary) {
        String w = "";
        for(int i = 0; i < 2*(dictionary.getObjective().getNumberOfTerms()+1)+1; i++) {
            w += "l ";
        }
        System.out.println("\\begin{tabular}{" + w + "}");
        for (int j = 0; j < dictionary.size(); j++) {
            this.printDictionaryEntry(dictionary.get(j));
            System.out.println("\\\\");
        }
        System.out.println("\\hline");
        this.printObjective(dictionary.getObjective());
        System.out.println("\\end{tabular} \\newline");
    }

    @Override
    public String formatVariable(int variable) {
        return String.format("$x_{%d}$", variable);
    }

    private void printDictionaryEntry(DictionaryEntry<T> dictionaryEntry) {
        System.out.println(String.format("$ x_{%d} $ & = %s", dictionaryEntry.getVariable(),
                this.formatLinearCombination(dictionaryEntry)));
    }
    private void printObjective(LinearCombination<T> objective) {
        System.out.println(String.format("$ z $  & = %s", this.formatLinearCombination(objective)));
    }

    private String formatLinearCombination(LinearCombination<T> lc) {
        String r = String.format("& $%s$ ", lc.getConstant().toString());
        for (int i = 0; i < lc.getNumberOfTerms(); i++) {
            r += String.format("& + & $%s x_{%d}$ ", lc.getConstantById(i),
                    lc.getVariableById(i));
        }
        return r;
    }


}
