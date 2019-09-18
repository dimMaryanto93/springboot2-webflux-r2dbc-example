package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.entity.ExampleEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExampleEntityRepository extends ReactiveCrudRepository<ExampleEntity, String> {

}
