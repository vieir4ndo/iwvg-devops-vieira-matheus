package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
