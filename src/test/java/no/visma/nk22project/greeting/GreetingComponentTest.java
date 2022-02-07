package no.visma.nk22project.greeting;

import no.visma.nk22project.ComponentTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingComponentTest extends ComponentTestBase {
    @Autowired
    private GreetingsController greetingsController;

    @Test
    void scenario1() {
        String name1 = "Even";
        String name2 = "Johanna";
        String name3 = "Grete";

        String result = greetingsController.greeting(name1, name2, name3);

        assertThat(result).contains(name1);
        assertThat(result).contains(name2);
        assertThat(result).contains(name3);
    }
}
