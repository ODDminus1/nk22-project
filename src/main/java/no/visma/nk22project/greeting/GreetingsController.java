package no.visma.nk22project.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GreetingsController {
    private final GreetingMapper greetingMapper;

    @GetMapping(path = "/greeting/{name1}")
    public String greeting(
            @PathVariable(value = "name1", required = false) String name1,
            @RequestParam(value = "name2", required = false) String name2,
            @RequestHeader(value = "name3", required = false) String name3
    ) {
        return greetingMapper.mappedGreeting(name1, name2, name3);
    }
}
