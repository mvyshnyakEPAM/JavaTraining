package ua.training.homework.entity;

import ua.training.homework.view.Constants;

/**
 * Максим
 * 14.03.2018
 */
public class Fraction {
    private int numerator;
    private int denominator;
    private String sign;

    public Fraction(int numerator, int denominator) {
        checkFraction(denominator);
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        this.sign = numerator < Constants.ZERO || denominator < Constants.ZERO ?
                Constants.NEGATIVE_SIGN : Constants.POSITIVE_SIGN;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getSign() {
        return sign;
    }

    private void checkFraction(int denominator) {
        if (denominator == Constants.ZERO) {
            throw new IllegalArgumentException(Constants.WRONG_FRACTION);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Fraction)) {
            return false;
        }

        Fraction that = (Fraction) obj;
        return this.numerator * that.getDenominator() ==
                this.denominator * that.getNumerator();
    }

    @Override
    public int hashCode() {
        return numerator / denominator + denominator / numerator;
    }

    @Override
    public String toString() {
        return sign + numerator + Constants.FORWARD_SLASH + denominator;
    }
}
