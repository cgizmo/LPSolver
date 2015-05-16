package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.DivisionRing.DivisionRing;

import java.util.HashMap;

/**
 * Created by quentin on 30/03/15.
 */
public class OptimalSolution<T> implements SimplexOutput<T> {
    T value;
    HashMap<Integer, T> solution;
    DivisionRing<T> ring;

    OptimalSolution(DivisionRing<T> ring, T value, HashMap<Integer, T> solution) {
        this.ring = ring;
        this.value = value;
        this.solution = solution;
    }
    @Override
    public void print() {
        System.out.println("Optimal solution: z = " + this.value.toString());
        for(Integer var: this.solution.keySet()) {
            System.out.printf("x_%d = %s\n", var, solution.get(var).toString());
        }
    }

    public T getValue() {
        return value;
    }

    public T getVariableValue(int variable) {
        if(solution.containsKey(variable))
            return solution.get(variable);
        else
            return ring.fromInteger(0);
    }
}
