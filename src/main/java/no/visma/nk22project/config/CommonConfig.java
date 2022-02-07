package no.visma.nk22project.config;

import no.visma.nk22project.greeting.GreetingMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CommonConfig {
    @Bean
    GreetingMapper greetingMapper() {
        return new GreetingMapper();
    }

    @Bean
    WebClient webClient() {
        return WebClient.create();
    }
}
