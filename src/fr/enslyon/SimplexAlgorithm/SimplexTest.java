package fr.enslyon.SimplexAlgorithm;

import fr.enslyon.DivisionRing.RationalDivisionRing;
import fr.enslyon.DivisionRing.RationalNumber;
import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.LinearCombination;
import org.junit.Test;

import java.util.ArrayList;

public class SimplexTest {

    @Test
    public void testSolve() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();

        // Max 2x_0 + x_1
        LinearCombination<RationalNumber> objective = new LinearCombination<RationalNumber>(2, 5, ring);
        objective.setConstant(ring.fromInteger(0));
        objective.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(1)});
        objective.setVariables(new int[]{0, 1});

        //st -2x_0 + x_1 <= -2
        // x_2 = -2 + 2x_0 - x_1
        DictionaryEntry<RationalNumber> equ1 = new DictionaryEntry<RationalNumber>(2, 5, ring, 2);
        equ1.setConstant(ring.fromInteger(-2));
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(-1)});
        equ1.setVariables(new int[]{0, 1});

        //st x_0 - 2 x_1 <= -2
        // x_3 = -2 - x_0 + 2x_1
        DictionaryEntry<RationalNumber> equ2 = new DictionaryEntry<RationalNumber>(2, 5, ring, 3);
        equ2.setConstant(ring.fromInteger(-2));
        equ2.setConstants(new RationalNumber[]{ring.fromInteger(-1), ring.fromInteger(2)});
        equ2.setVariables(new int[]{0, 1});

        //st x_0 + x_1 <= 7
        // x_3 = 7 - x_0 - x_1
        DictionaryEntry<RationalNumber> equ3 = new DictionaryEntry<RationalNumber>(2, 5, ring, 4);
        equ3.setConstant(ring.fromInteger(7));
        equ3.setConstants(new RationalNumber[]{ring.fromInteger(-1), ring.fromInteger(-1)});
        equ3.setVariables(new int[]{0, 1});

        ArrayList<DictionaryEntry<RationalNumber>> eqs = new ArrayList<DictionaryEntry<RationalNumber>>(3);
        eqs.add(0, equ1); eqs.add(1, equ2); eqs.add(2, equ3);

        Simplex<RationalNumber> s = new Simplex<RationalNumber>(objective, eqs, ring);
        SimplexOutput<RationalNumber> solution = s.solve();


        org.junit.Assert.assertTrue(solution instanceof OptimalSolution);
        OptimalSolution<RationalNumber> optS = (OptimalSolution<RationalNumber>) solution;

        org.junit.Assert.assertEquals(ring.fromInteger(11), optS.getValue());

        org.junit.Assert.assertEquals(ring.fromInteger(4), optS.getVariableValue(0));
        org.junit.Assert.assertEquals(ring.fromInteger(3), optS.getVariableValue(1));
    }

    @Test
    public void testComputeAVertex() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();

        // Max 2x_0 + x_1
        LinearCombination<RationalNumber> objective = new LinearCombination<RationalNumber>(2, 5, ring);
        objective.setConstant(ring.fromInteger(0));
        objective.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(1)});
        objective.setVariables(new int[]{0, 1});

        //st -2x_0 + x_1 <= -2
        // x_2 = -2 + 2x_0 - x_1
        DictionaryEntry<RationalNumber> equ1 = new DictionaryEntry<RationalNumber>(2, 5, ring, 2);
        equ1.setConstant(ring.fromInteger(-2));
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(-1)});
        equ1.setVariables(new int[]{0, 1});

        //st x_0 - 2 x_1 <= -2
        // x_3 = -2 - x_0 + 2x_1
        DictionaryEntry<RationalNumber> equ2 = new DictionaryEntry<RationalNumber>(2, 5, ring, 3);
        equ2.setConstant(ring.fromInteger(-2));
        equ2.setConstants(new RationalNumber[]{ring.fromInteger(-1), ring.fromInteger(2)});
        equ2.setVariables(new int[]{0, 1});

        //st x_0 + x_1 <= 7
        // x_3 = 7 - x_0 - x_1
        DictionaryEntry<RationalNumber> equ3 = new DictionaryEntry<RationalNumber>(2, 5, ring, 4);
        equ3.setConstant(ring.fromInteger(7));
        equ3.setConstants(new RationalNumber[]{ring.fromInteger(-1), ring.fromInteger(-1)});
        equ3.setVariables(new int[]{0, 1});

        ArrayList<DictionaryEntry<RationalNumber>> eqs = new ArrayList<DictionaryEntry<RationalNumber>>(3);
        eqs.add(0, equ1); eqs.add(1, equ2); eqs.add(2, equ3);

        Simplex<RationalNumber> s = new Simplex<RationalNumber>(objective, eqs, ring);

        SimplexOutput<RationalNumber> vertex = s.computeAVertex();

        org.junit.Assert.assertTrue(vertex instanceof OptimalSolution);

        org.junit.Assert.assertEquals(ring.fromInteger(0), ((OptimalSolution) vertex).getValue());

        RationalNumber v0 = ((OptimalSolution<RationalNumber>) vertex).getVariableValue(0);
        RationalNumber v1 = ((OptimalSolution<RationalNumber>) vertex).getVariableValue(1);

        org.junit.Assert.assertEquals(ring.fromInteger(2), v0);
        org.junit.Assert.assertEquals(ring.fromInteger(2), v1);


    }

}