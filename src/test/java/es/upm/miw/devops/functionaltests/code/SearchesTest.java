package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Searches;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchesTest {

    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertThat(new Searches().findUserFamilyNameByUserNameDistinct("Paula").toList())
                .containsExactly("Torres");
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertThat(new Searches().findFractionNumeratorByUserFamilyName("Torres").toList())
                .containsExactly(2, 4, 0, 1, 1);
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertThat(new Searches().findUserFamilyNameByFractionDenominator(2).toList())
                .containsExactly("López", "Torres", "Torres");
    }

    void testFindUserIdByAnyProperFraction() {
    }

    void testFindUserNameByAnyImproperFraction() {
    }

    void testFindUserFamilyNameByAllSignFractionDistinct() {
    }

    void testFindDecimalFractionByUserName() {
    }

    void testFindDecimalFractionBySignFraction() {
    }

    void testFindFractionAdditionByUserId() {
    }

    @Test
    void testFindFractionSubtractionByUserName() {
        var subtraction = new Searches().findFractionSubtractionByUserName("Paula");
        assertThat(subtraction.decimal()).isEqualTo((double) -4/3);
    }

    void testFindFractionMultiplicationByUserFamilyName() {
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        assertThat(new Searches().findUserFamilyNameBySomeImproperFraction().toList())
                .containsExactlyInAnyOrder("Fernandez", "Blanco", "López", "Blanco");
    }

    @Test
    void testFindUserIdBySomeProperFraction(){
        assertThat(new Searches().findUserIdBySomeProperFraction().toList())
                .containsExactlyInAnyOrder("1", "2", "3", "5", "6");
    }
}