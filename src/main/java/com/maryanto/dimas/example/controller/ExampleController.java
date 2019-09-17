package com.maryanto.dimas.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @GetMapping("/test")
    public Mono<String> test() {
        return Mono.justOrEmpty("Testing");
    }
}
