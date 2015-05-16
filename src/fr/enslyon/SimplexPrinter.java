package fr.enslyon;

import fr.enslyon.DivisionRing.DivisionRing;
import fr.enslyon.Parser.LinearProgram;
import fr.enslyon.SimplexAlgorithm.EmptyDomain;
import fr.enslyon.SimplexAlgorithm.OptimalSolution;
import fr.enslyon.SimplexAlgorithm.SimplexOutput;
import fr.enslyon.SimplexAlgorithm.UnboundedSolution;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by quentin on 03/05/15.
 * The output skeleton
 */
public abstract class SimplexPrinter<T> {
    protected boolean isObjectiveMaximize;
    protected HashSet<String> variables;
    protected HashMap<String, Integer> variablesIndex;
    protected HashMap<String, String> composedVariables;
    protected DivisionRing<T> ring;
    protected PrintStream printStream = System.out;



    public SimplexPrinter(boolean isObjectiveMaximize, DivisionRing<T> ring, HashSet<String> variables,
                                HashMap<String, Integer> variablesIndex, HashMap<String, String> composedVariables) {
        this.isObjectiveMaximize = isObjectiveMaximize;
        this.variables = variables;
        this.variablesIndex = variablesIndex;
        this.composedVariables = composedVariables;
        this.ring = ring;

    }

    abstract public void printHeader();
    abstract public void printFooter();
    abstract public void printLinearProgram(LinearProgram<T> linearProgram);
    abstract public void printMessage(String m);

    public void printSolution(SimplexOutput<T> solution) {
        if(solution instanceof OptimalSolution) {
            this.printOptimalSolution((OptimalSolution<T>) solution);
        }
        else if(solution instanceof EmptyDomain) {
            solution.print();
        }
        else if(solution instanceof UnboundedSolution) {
            this.printUnboundedSolution((UnboundedSolution<T>) solution);
        }
    }


    private void printOptimalSolution(OptimalSolution<T> optimalSolution) {
        T optimalValue = optimalSolution.getValue();
        if(!isObjectiveMaximize) {
            optimalValue = ring.opposite(optimalValue);
        }
        this.printMessage(String.format("Optimal solution: %s", optimalValue.toString()));

        for(String var: variables) {
            T value = optimalSolution.getVariableValue(variablesIndex.get(var));
            if(composedVariables.containsKey(var)) {
                String var2 = composedVariables.get(var);
                int index2 = variablesIndex.get(var2);
                T value2 = optimalSolution.getVariableValue(index2);
                value = ring.add(value, ring.opposite(value2));
            }
            printStream.printf("%s = %s\n", var, value);
        }
    }

    private void printUnboundedSolution(UnboundedSolution<T> unboundedSolution) {
        this.printMessage("Unbounded solution");
        for(String var: variables) {
            T constantCoefficient = unboundedSolution.getConstant(variablesIndex.get(var));
            T unboundedCoefficient = unboundedSolution.getUnboundedCoefficient(variablesIndex.get(var));

            if (composedVariables.containsKey(var)) {
                String var2 = composedVariables.get(var);
                T constantCoefficient2 = unboundedSolution.getConstant(variablesIndex.get(var2));
                T unboundedCoefficient2 = unboundedSolution.getUnboundedCoefficient(variablesIndex.get(var2));

                constantCoefficient = ring.add(constantCoefficient, ring.opposite(constantCoefficient2));
                unboundedCoefficient = ring.add(unboundedCoefficient, ring.opposite(unboundedCoefficient2));
            }

            this.printMessage(String.format("%s = %s + %s t", var, constantCoefficient.toString(),
                    unboundedCoefficient.toString()));
        }
        this.printMessage("t non negative");
    }


}
