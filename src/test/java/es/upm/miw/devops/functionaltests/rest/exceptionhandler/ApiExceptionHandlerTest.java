package es.upm.miw.devops.functionaltests.rest.exceptionhandler;

import es.upm.miw.devops.rest.exceptionshandler.ApiExceptionHandler;
import es.upm.miw.devops.rest.exceptionshandler.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.assertj.core.api.Assertions.assertThat;

class ApiExceptionHandlerTest {

    private ApiExceptionHandler apiExceptionHandler;

    @BeforeEach
    void setUp() {
        this.apiExceptionHandler = new ApiExceptionHandler();
    }

    @Test
    void testNoResourceFoundRequest_WithNoResourceFoundException() {
        Exception exception = new NoResourceFoundException(HttpMethod.GET, "/not-found");

        ErrorMessage errorMessage = apiExceptionHandler.noResourceFoundRequest(exception);

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage())
                .contains("Ruta no encontrada")
                .contains("/actuator/info")
                .contains("/swagger-ui.html")
                .contains("/v3/api-docs")
                .contains("/v3/api-docs.yaml");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void testNoResourceFoundRequest_WithResponseStatusException() {
        Exception exception = new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");

        ErrorMessage errorMessage = apiExceptionHandler.noResourceFoundRequest(exception);

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage()).contains("Ruta no encontrada");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void testExceptionHandler_GenericException() {
        Exception exception = new Exception("Some internal error");

        ErrorMessage errorMessage = apiExceptionHandler.exception(exception);

        assertThat(errorMessage.getError()).isEqualTo("RuntimeException");
        assertThat(errorMessage.getMessage()).isEqualTo("ERROR");
        assertThat(errorMessage.getCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
