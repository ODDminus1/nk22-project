package no.visma.nk22project.greeting;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class GreetingMapper {
    public String mappedGreeting(String... names) {
        return Arrays.stream(names)
                .map("my good friend %s"::formatted)
                .collect(joining(", "));
    }
}
