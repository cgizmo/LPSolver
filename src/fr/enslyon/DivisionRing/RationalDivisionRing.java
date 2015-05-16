package fr.enslyon.DivisionRing;

/**
 * Created by quentin on 14/04/15.
 */
public class RationalDivisionRing implements DivisionRing<RationalNumber> {
    @Override
    public RationalNumber add(RationalNumber x, RationalNumber y) {
        return new RationalNumber(x.getNominator() * y.getDenominator() + y.getNominator() * x.getDenominator(),
                x.getDenominator() * y.getDenominator());
    }

    @Override
    public RationalNumber prod(RationalNumber x, RationalNumber y) {
        return new RationalNumber(x.getNominator() * y.getNominator(), x.getDenominator() * y.getDenominator());
    }

    @Override
    public RationalNumber inverse(RationalNumber x) {
        return new RationalNumber(x.getDenominator(), x.getNominator());
    }

    @Override
    public RationalNumber opposite(RationalNumber x) {
        return new RationalNumber(-x.getNominator(), x.getDenominator());
    }

    @Override
    public RationalNumber fromInteger(int n) {
        return new RationalNumber(n, 1);
    }

    @Override
    public RationalNumber fromString(String n) {
        return new RationalNumber(Double.valueOf(n));
    }

    @Override
    public int compare(RationalNumber x, RationalNumber y) {
        long a = x.getNominator() * y.getDenominator();
        long b = x.getDenominator() * y.getNominator();

        if(a < b)
            return -1;
        else if(a == b)
            return 0;
        else
            return 1;
    }
}