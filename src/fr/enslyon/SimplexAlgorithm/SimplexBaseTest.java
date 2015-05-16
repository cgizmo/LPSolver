package fr.enslyon.SimplexAlgorithm;
import fr.enslyon.DivisionRing.RationalDivisionRing;
import fr.enslyon.DivisionRing.RationalNumber;
import fr.enslyon.LinearCombination.DictionaryEntry;
import fr.enslyon.LinearCombination.LinearCombination;
import org.junit.Test;

import java.util.ArrayList;

public class SimplexBaseTest {
    @Test
    public void testGetUnboundedSolution() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();
        // Max 6 + x_1 - x_3
        LinearCombination<RationalNumber> objective = new LinearCombination<RationalNumber>(2, 4, ring);
        objective.setConstant(ring.fromInteger(6));
        objective.setConstants(new RationalNumber[]{ring.fromInteger(1), ring.fromInteger(-1)});
        objective.setVariables(new int[]{1, 3});

        // x_2 = 4 + 2x_1 + x_3
        DictionaryEntry<RationalNumber> e0 = new DictionaryEntry<RationalNumber>(2, 4, ring, 2);
        e0.setConstant(ring.fromInteger(4));
        e0.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(1)});
        e0.setVariables(new int[]{1, 3});

        // x_0 = 4 + 2x_1 + x_3
        DictionaryEntry<RationalNumber> e1 = new DictionaryEntry<RationalNumber>(2, 4, ring, 0);
        e1.setConstant(ring.fromInteger(2));
        e1.setConstants(new RationalNumber[]{ring.fromInteger(0), ring.fromInteger(-1)});
        e1.setVariables(new int[]{1, 3});

        ArrayList<DictionaryEntry<RationalNumber>> eqs = new ArrayList<DictionaryEntry<RationalNumber>>(3);
        eqs.add(0, e0); eqs.add(1, e1);
        SimplexBase<RationalNumber> s = new SimplexBase<RationalNumber>(objective, eqs, ring);

        SimplexOutput<RationalNumber> solution = s.solve();

        org.junit.Assert.assertTrue(solution instanceof UnboundedSolution);

    }

    @Test
    public void testSolve() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();
        // Max 5x_0 + 4x_1 + 3x_2
        LinearCombination<RationalNumber> objective = new LinearCombination<RationalNumber>(3, 6, ring);
        objective.setConstant(ring.fromInteger(0));
        objective.setConstants(new RationalNumber[]{ring.fromInteger(5), ring.fromInteger(4), ring.fromInteger(3)});
        objective.setVariables(new int[]{0, 1, 2});

        //st 2x_0 + 3_x_1 + x_2 <= 5
        // x_3 = 5 - 2x_0 - 3x_1 -x_2
        DictionaryEntry<RationalNumber> equ1 = new DictionaryEntry<RationalNumber>(3, 6, ring, 3);
        equ1.setConstant(ring.fromInteger(5));
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(-2), ring.fromInteger(-3), ring.fromInteger(-1)});
        equ1.setVariables(new int[]{0, 1, 2});

        //st 4x_0+x_1+2x_2 <= 11
        // x_4 = 11-4x_0-x_1 - 2x_2
        DictionaryEntry<RationalNumber> equ2 = new DictionaryEntry<RationalNumber>(3, 6, ring, 4);
        equ2.setConstant(ring.fromInteger(11));
        equ2.setConstants(new RationalNumber[]{ring.fromInteger(-4), ring.fromInteger(-1), ring.fromInteger(-2)});
        equ2.setVariables(new int[]{0, 1, 2});

        //st 3x_0+4x_1+2x_2 <= 8
        // x_5 = 8-3x_0-4x_1 - 2x_2
        DictionaryEntry<RationalNumber> equ3 = new DictionaryEntry<RationalNumber>(3, 6, ring, 5);
        equ3.setConstant(ring.fromInteger(8));
        equ3.setConstants(new RationalNumber[]{ring.fromInteger(-3), ring.fromInteger(-4), ring.fromInteger(-2)});
        equ3.setVariables(new int[]{0, 1, 2});

        ArrayList<DictionaryEntry<RationalNumber>> eqs = new ArrayList<DictionaryEntry<RationalNumber>>(3);
        eqs.add(0, equ1); eqs.add(1, equ2); eqs.add(2, equ3);

        SimplexBase<RationalNumber> s = new SimplexBase<RationalNumber>(objective, eqs, ring);
        SimplexOutput<RationalNumber> solution = s.solve();

        org.junit.Assert.assertTrue(solution instanceof OptimalSolution);
        RationalNumber value = ((OptimalSolution<RationalNumber>) solution).getValue();

        org.junit.Assert.assertEquals(ring.fromInteger(13), value);


    }

}