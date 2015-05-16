package fr.enslyon.Parser;

import java.util.HashSet;

/**
 * Created by quentin on 16/04/15.
 */
public class Variables {
    private int generatorNameVariable;
    private HashSet<String> variables;
    Variables() {
        generatorNameVariable = 0;
        this.variables = new HashSet<String>();
    }
    public void add(String s) {
        variables.add(s);
    }
    public String add() {
        String var = "nx_" +Integer.toString(this.generatorNameVariable);
        if(!variables.contains(var)) {
            variables.add(var);
            return var;
        }
        else {
            this.generatorNameVariable++;
            return this.add();
        }
    }

    public HashSet<String> getVariables() {
        return variables;
    }

    public String toString() {
        String output = "";
        for(String var: variables) {
            output += var + "\n";
        }
        return output;
    }
}
