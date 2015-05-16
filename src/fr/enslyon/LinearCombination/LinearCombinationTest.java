package fr.enslyon.LinearCombination;

import fr.enslyon.DivisionRing.RationalDivisionRing;
import fr.enslyon.DivisionRing.RationalNumber;
import org.junit.Test;

public class LinearCombinationTest {

    @Test
    public void testSubstitute() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();

        //v_2 = 5.0  + 1.0 * v_0  + 2.0 * v_1  + 3.0 * v_3
        LinearCombination<RationalNumber> equ1 = new LinearCombination<RationalNumber>(3, 5, ring);
        equ1.setConstant(ring.fromInteger(5));
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(1), ring.fromInteger(2), ring.fromInteger(3)});
        equ1.setVariables(new int[]{0, 1, 3});

        //v_3 = 7.0  + 2.0 * v_0  + 1.0 * v_1  + 1.0 * v_4
        DictionaryEntry<RationalNumber> equ2 = new DictionaryEntry<RationalNumber>(3, 5, ring, 3);
        equ2.setConstant(ring.fromInteger(7));
        equ2.setConstants(new RationalNumber[]{ring.fromInteger(2), ring.fromInteger(1), ring.fromInteger(1)});
        equ2.setVariables(new int[]{0, 1, 4});


        equ1.substitute(equ2); // -> v_2 = 26.0  + 7.0 * v_0  + 5.0 * v_1  + 3.0 * v_4

        org.junit.Assert.assertArrayEquals("failure - variables not the same",
                new int[]{0, 1, 4},
                new int[]{equ1.getVariableById(0), equ1.getVariableById(1), equ1.getVariableById(2)});

        org.junit.Assert.assertEquals(ring.fromInteger(26), equ1.getConstant());

        org.junit.Assert.assertArrayEquals("failure - constants not the same",
                new RationalNumber[]{ring.fromInteger(7), ring.fromInteger(5), ring.fromInteger(3)},
                new RationalNumber[]{equ1.getConstantById(0), equ1.getConstantById(1), equ1.getConstantById(2)});
    }
}