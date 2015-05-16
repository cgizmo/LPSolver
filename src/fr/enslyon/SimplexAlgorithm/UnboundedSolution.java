package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.DivisionRing.DivisionRing;

import java.util.HashMap;
import java.util.List;

/**
 * Created by quentin on 31/03/15.
 */
public class UnboundedSolution<T> implements SimplexOutput<T> {
    private int enteringVariable;
    private HashMap<Integer, List<T>> solution;
    private DivisionRing<T> ring;

    UnboundedSolution(DivisionRing<T> ring, int enteringVariable, HashMap<Integer, List<T>> solution) {
        this.ring = ring;
        this.enteringVariable = enteringVariable;
        this.solution = solution;
    }
    @Override
    public void print() {
        System.out.println("Unbounded solution");
        System.out.printf("x_%d = t, t>=0\n", enteringVariable);
        for(Integer variable: solution.keySet()) {
            System.out.printf("x_%d = %s + %s t\n", variable, solution.get(variable).get(0),
                    solution.get(variable).get(1));
        }
    }

    public T getConstant(int variable) {
        if(solution.containsKey(variable)) {
            return solution.get(variable).get(0);
        }
        else {
            return ring.fromInteger(0);
        }
    }
    public T getUnboundedCoefficient(int variable) {
        if(variable == enteringVariable) {
            return ring.fromInteger(1);
        }
        else if(solution.containsKey(variable)) {
            return solution.get(variable).get(1);
        }
        else {
            return ring.fromInteger(0);
        }
    }
}
