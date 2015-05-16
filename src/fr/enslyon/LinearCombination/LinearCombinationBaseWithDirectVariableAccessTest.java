package fr.enslyon.LinearCombination;

import fr.enslyon.DivisionRing.RationalDivisionRing;
import fr.enslyon.DivisionRing.RationalNumber;
import org.junit.Test;

public class LinearCombinationBaseWithDirectVariableAccessTest {
    @Test
    public void testGetIndexVariable() throws Exception {
        RationalDivisionRing ring = new RationalDivisionRing();

        LinearCombinationBaseWithDirectVariableAccess<RationalNumber> equ1 =
                new LinearCombinationBaseWithDirectVariableAccess<RationalNumber>(3, 5);
        equ1.setConstants(new RationalNumber[]{ring.fromInteger(1), ring.fromInteger(2), ring.fromInteger(3)});
        equ1.setVariables(new int[]{0, 1, 3});

        org.junit.Assert.assertEquals(2, equ1.getIndexVariable(3));
    }

}