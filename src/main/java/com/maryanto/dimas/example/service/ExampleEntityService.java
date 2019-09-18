package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.dao.ExampleDao;
import com.maryanto.dimas.example.dto.ExampleEntityDto;
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
        return dao.save(data);
    }

    public Flux<ExampleEntityDto.Response> findAll() {
        return dao.findAll();
    }
}
