package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.dao.ExampleDao;
import com.maryanto.dimas.example.entity.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExampleEntityService {

    @Autowired
    private ExampleDao dao;

    public Mono<ExampleEntity> save(ExampleEntity data) {
        data = dao.save(data);
        return Mono.justOrEmpty(data);
    }

    public Flux<ExampleEntity> findAll() {
        return Flux.fromIterable(dao.findAll());
    }
}
