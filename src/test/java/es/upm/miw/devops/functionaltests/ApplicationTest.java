package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.mockStatic;

@SpringBootTest
class ApplicationTest {

    @Test
    void contextLoads() {
        assertThatCode(() -> {
        }).doesNotThrowAnyException();
    }

    @Test
    void mainRunsSpringApplication() {
        try (var mocked = mockStatic(SpringApplication.class)) {
            Application.main(new String[]{});

            mocked.verify(() -> SpringApplication.run(Application.class, new String[]{}));
        }
    }
}
