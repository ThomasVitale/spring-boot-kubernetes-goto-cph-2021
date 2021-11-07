package com.thomasvitale.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNativeApplication.class, args);
    }

}

@ConfigurationProperties(prefix = "demo")
record DemoProperties(String message){}

@RestController
class DemoController {

    private final DemoProperties demoProperties;

    DemoController(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    @GetMapping
    Mono<String> getMessage() {
        return Mono.just(demoProperties.message());
    }

}
