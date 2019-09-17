package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.entity.ExampleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<ExampleEntity, String> {
}
