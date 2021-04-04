package cz.educanet;

public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator; // to nahoře
        this.denominator = denominator; // to dole
    }

    //region: basic operations (+, -, *, /)


    //Adds the fraction to the other fraction. Returns a new fraction.

    public Fraction plus(Fraction other) {
        int lcm, count;
        lcm = MathUtils.findLowestCommonMultiple(denominator, other.denominator);
        count = (numerator * lcm / denominator) + (other.numerator * lcm / other.denominator);

        return new Fraction(count, lcm);
    }


    //Subtracts other from the fraction. Returns a new fraction.
    public Fraction minus(Fraction other) {
        int lcm, count;
        lcm = MathUtils.findLowestCommonMultiple(denominator, other.denominator);

        count = (numerator * lcm / denominator) - (other.numerator * lcm / other.denominator);

        return new Fraction(count, lcm);
    }


    //Multiplies the two fractions. Returns a new fraction.

    public Fraction times(Fraction other) {
        int countNum, countDenom;

        countNum = numerator * other.numerator;
        countDenom = denominator * other.denominator;

        return new Fraction(countNum, countDenom);
    }


    //Divides the two fractions (this / other). Returns a new fraction.
    public Fraction dividedBy(Fraction other) {
        int countNum, countDenom;

        countNum = numerator * other.getReciprocal().numerator;
        countDenom = denominator * other.getReciprocal().denominator;

        return new Fraction(countNum, countDenom);
    }
    //endregion

    //region: other operations


    //Gets the reciprocal (flipped) of the fraction. ie. reciprocal of 1/2 is 2/1
    public Fraction getReciprocal() {
        return new Fraction(denominator, numerator);
    }

    //Simplifies the fraction
    public Fraction simplify() {
        int gcd = MathUtils.findGreatestCommonDenominator(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }


    //Calculates the floating value of the fraction.
    public float toFloat() {
        return (float) numerator / (float) denominator;
    }
    //endregion

    //region: getters
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    //endregion
}
