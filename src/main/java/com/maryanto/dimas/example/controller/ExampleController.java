package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.example.service.ExampleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    private ExampleEntityService service;

    @PostMapping("/save")
    public Mono<ExampleEntity> save(@RequestBody ExampleEntity entity) {
        return service.save(entity);
    }

    @GetMapping("/list")
    public Flux<ExampleEntity> findAll() {
        return service.findAll();
    }
}
