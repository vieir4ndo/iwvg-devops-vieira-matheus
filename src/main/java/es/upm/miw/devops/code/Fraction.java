package es.upm.miw.devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        if (fraction == null) {
            return false;
        }

        return (long) this.numerator * fraction.denominator ==
                (long) this.denominator * fraction.numerator;
    }

    public Fraction multiply(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }

        return new Fraction(getNumerator() * fraction.getNumerator(), getDenominator() * fraction.getDenominator());
    }

    public Fraction divide(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }

        if (fraction.getNumerator() == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }

        return multiply(new Fraction(fraction.getDenominator(), fraction.getNumerator()));
    }

    public Fraction add(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("Fraction cannot be null.");
        }

        int commonDenominator = this.denominator * fraction.denominator;
        int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;

        return new Fraction(newNumerator, commonDenominator);
    }
}
