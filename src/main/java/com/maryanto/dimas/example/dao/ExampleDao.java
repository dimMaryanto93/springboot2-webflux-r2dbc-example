package com.maryanto.dimas.example.dao;

import com.maryanto.dimas.example.entity.ExampleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class ExampleDao {

    @Autowired
    private DatabaseClient client;

    public Mono<ExampleEntity> save(ExampleEntity data) {
        log.info("{}", data);
        Mono<ExampleEntity> rowUpdated = client.insert().into("examples")
                .value("nama", data.getNama())
                .value("tanggal_lahir", data.getTanggalLahir())
                .value("saldo", data.getSaldo())
                .value("created_date", data.getCreatedDate())
                .then().thenReturn(data);
        return rowUpdated;
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
