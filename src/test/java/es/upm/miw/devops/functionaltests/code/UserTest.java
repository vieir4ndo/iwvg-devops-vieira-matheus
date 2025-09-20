package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.User;
import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertThat(user.getFractions()).isNotNull().isEmpty();
    }

    @Test
    void testParameterizedConstructorAndGetters() {
        List<Fraction> fractions = Arrays.asList(new Fraction(), new Fraction());
        User user = new User("1", "Mario", "Rossi", fractions);
        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("Mario");
        assertThat(user.getFamilyName()).isEqualTo("Rossi");
        assertThat(user.getFractions()).isEqualTo(fractions);
    }

    @Test
    void testSetters() {
        User user = new User();
        user.setName("Luca");
        user.setFamilyName("Bianchi");
        user.setFractions(Collections.emptyList());
        assertThat(user.getName()).isEqualTo("Luca");
        assertThat(user.getFamilyName()).isEqualTo("Bianchi");
        assertThat(user.getFractions()).isEmpty();
    }

    @Test
    void testAddFraction() {
        User user = new User();
        Fraction fraction = new Fraction();
        user.addFraction(fraction);
        assertThat(user.getFractions()).hasSize(1).contains(fraction);
    }

    @Test
    void testFullName() {
        User user = new User("2", "Anna", "Verdi", Collections.emptyList());
        assertThat(user.fullName()).isEqualTo("Anna Verdi");
    }

    @Test
    void testInitials() {
        User user = new User("3", "Paolo", "Neri", Collections.emptyList());
        assertThat(user.initials()).isEqualTo("P.");
    }

    @Test
    void testToString() {
        User user = new User("4", "Sara", "Blu", Collections.emptyList());
        String toString = user.toString();
        assertThat(toString).contains("Sara", "Blu", "id='4'");
    }
}
