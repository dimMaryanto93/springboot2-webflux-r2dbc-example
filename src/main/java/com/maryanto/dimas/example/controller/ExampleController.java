package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.dto.ExampleEntityDto;
import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.example.mappers.ExampleEntityMapper.ExampleEntityCreate;
import com.maryanto.dimas.example.service.ExampleEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    private ExampleEntityService service;

    @PostMapping("/save")
    public Mono<ExampleEntity> save(@RequestBody @Valid ExampleEntityDto.Create dto) {
        ExampleEntity entity = ExampleEntityCreate.instance.convertToEntity(dto);
        entity.setCreatedDate(LocalDateTime.now());
        return service.save(entity);
    }

    @GetMapping("/list")
    public Flux<ExampleEntityDto.Response> findAll() {
        return service.findAll();
    }
}
