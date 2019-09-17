package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.entity.ExampleEntity;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ExampleRepository extends ReactiveCrudRepository<ExampleEntity, String> {

    @Query("select id, nama, umur, tanggal_lahir, saldo, created_date from examples")
    Flux<ExampleEntity> findAll();
}
