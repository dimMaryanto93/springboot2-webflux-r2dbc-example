package com.maryanto.dimas.example.dao;

import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.example.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExampleDao {

    @Autowired
    private ExampleRepository repository;

    public ExampleEntity save(ExampleEntity data) {
        return repository.save(data);
    }

    public Iterable<ExampleEntity> findAll(){
        return repository.findAll();
    }
}
