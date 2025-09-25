package es.upm.miw.devops.functionaltests.rest.exceptionhandler;

import es.upm.miw.devops.rest.exceptionshandler.ErrorMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {

    @Test
    void testConstructorAndGetters() {
        Exception exception = new IllegalArgumentException("Invalid argument");
        int code = 400;

        ErrorMessage errorMessage = new ErrorMessage(exception, code);

        assertThat(errorMessage.getError()).isEqualTo("IllegalArgumentException");
        assertThat(errorMessage.getMessage()).isEqualTo("Invalid argument");
        assertThat(errorMessage.getCode()).isEqualTo(400);
    }

    @Test
    void testToStringContainsAllFields() {
        Exception exception = new NullPointerException("Something went wrong");
        int code = 500;
        ErrorMessage errorMessage = new ErrorMessage(exception, code);

        String result = errorMessage.toString();

        assertThat(result)
                .contains("error='NullPointerException'")
                .contains("message='Something went wrong'")
                .contains("code=500");
    }

    @Test
    void testNullMessageException() {
        Exception exception = new RuntimeException();
        int code = 123;

        ErrorMessage errorMessage = new ErrorMessage(exception, code);

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage()).isNull();
        assertThat(errorMessage.getCode()).isEqualTo(123);
    }
}
