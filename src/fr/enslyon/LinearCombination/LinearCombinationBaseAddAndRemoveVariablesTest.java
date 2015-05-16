package fr.enslyon.LinearCombination;

import fr.enslyon.DivisionRing.RationalDivisionRing;
import fr.enslyon.DivisionRing.RationalNumber;
import org.junit.Test;

public class LinearCombinationBaseAddAndRemoveVariablesTest {
    @Test
    public void testAddVariable() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();
        LinearCombinationBaseAddAndRemoveVariables<RationalNumber> equ1 =
                new  LinearCombinationBaseAddAndRemoveVariables<RationalNumber>(3, 5);
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(1), ring.fromInteger(2), ring.fromInteger(4)});
        equ1.setVariables(new int[]{0, 1, 3});

        equ1.addVariable(ring.fromInteger(-1));

        org.junit.Assert.assertArrayEquals("failure - variables not the same",
                new int[] {0, 1, 3, 5},
                new int[] {equ1.getVariableById(0), equ1.getVariableById(1),
                        equ1.getVariableById(2), equ1.getVariableById(3)});

        org.junit.Assert.assertArrayEquals("failure - constants not the same",
                new RationalNumber[] {ring.fromInteger(1), ring.fromInteger(2),
                        ring.fromInteger(4), ring.fromInteger(-1)},
                new RationalNumber[]{equ1.getConstantById(0), equ1.getConstantById(1),
                        equ1.getConstantById(2), equ1.getConstantById(3)});
    }
}