package com.maryanto.dimas.example.dao;

import com.maryanto.dimas.example.entity.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ExampleDao {

    @Autowired
    private DatabaseClient client;

    public Mono<ExampleEntity> save(ExampleEntity data) {
        return null;
    }

    public Flux<ExampleEntity> findAll() {
        Flux<ExampleEntity> list = client.select().from("examples")
                .orderBy(Sort.Order.asc("umur"))
                .as(ExampleEntity.class)
                .fetch()
                .all();
        return list;
    }
}
