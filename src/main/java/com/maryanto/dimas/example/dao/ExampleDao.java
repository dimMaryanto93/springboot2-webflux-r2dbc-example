package com.maryanto.dimas.example.dao;

import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ExampleDao {

    @Autowired
    private ExampleRepository repository;

    public Mono<ExampleEntity> save(ExampleEntity data) {
        return repository.save(data);
    }

    public Flux<ExampleEntity> findAll(){
        return repository.findAll();
    }
}
