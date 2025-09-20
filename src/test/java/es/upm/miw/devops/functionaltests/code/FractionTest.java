package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FractionTest {

    @Test
    void testConstructorAndGetters() {
        Fraction fraction = new Fraction(3, 4);
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testSetters() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        fraction.setDenominator(7);
        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(7);
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction.decimal()).isEqualTo(0.5);
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);
        assertThat(fraction.toString()).isEqualTo("Fraction{numerator=2, denominator=3}");
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertThat(result.getNumerator()).isEqualTo(5);
        assertThat(result.getDenominator()).isEqualTo(6);
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);
        assertThat(result.getNumerator()).isEqualTo(6);
        assertThat(result.getDenominator()).isEqualTo(12);
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(2, 7);
        Fraction result = f1.divide(f2);
        assertThat(result.getNumerator()).isEqualTo(21);
        assertThat(result.getDenominator()).isEqualTo(10);
    }

    @Test
    void testDivideByZeroNumerator() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(0, 3);
        assertThatThrownBy(() -> f1.divide(f2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Division by zero");
    }

    @Test
    void testIsEquivalentTrue() {
        Fraction f1 = new Fraction(2, 4);
        Fraction f2 = new Fraction(1, 2);
        assertThat(f1.isEquivalent(f2)).isTrue();
    }

    @Test
    void testIsEquivalentFalse() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        assertThat(f1.isEquivalent(f2)).isFalse();
    }

    @Test
    void testIsProper() {
        Fraction f = new Fraction(2, 5);
        assertThat(f.isProper()).isTrue();
        Fraction improper = new Fraction(7, 3);
        assertThat(improper.isProper()).isFalse();
    }

    @Test
    void testIsImproper() {
        Fraction f = new Fraction(7, 3);
        assertThat(f.isImproper()).isTrue();
        Fraction proper = new Fraction(2, 5);
        assertThat(proper.isImproper()).isFalse();
    }
}
