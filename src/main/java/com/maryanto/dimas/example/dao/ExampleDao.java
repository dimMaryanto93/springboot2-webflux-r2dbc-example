package com.maryanto.dimas.example.dao;

import com.maryanto.dimas.example.dto.ExampleEntityDto;
import com.maryanto.dimas.example.entity.ExampleEntity;
import com.maryanto.dimas.example.repository.ExampleEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Repository
public class ExampleDao {

    @Autowired
    private DatabaseClient client;

    @Autowired
    private ExampleEntityRepository repository;

    public Mono<ExampleEntity> save(ExampleEntity data) {
        return repository.save(data);
//        return null;
    }

    public Mono<Void> update(ExampleEntity data) {
        log.info("{}", data);
        Mono<Void> rowUpdated = client
                .execute("update examples\n" +
                        "set name          = :name,\n" +
                        "    age          = :age,\n" +
                        "    birthdate = :birthdate\n" +
                        "where id = :id")
                .bind("name", data.getNama())
                .bind("age", data.getUmur())
                .bind("birthdate", data.getTanggalLahir())
                .bind("id", data.getId())
                .then();
        return rowUpdated;
    }

    public Flux<ExampleEntityDto.Response> findAll() {
        Flux<ExampleEntityDto.Response> list = client.select().from(ExampleEntity.class)
                .orderBy(Sort.Order.asc("umur"))
                .map(
                        (row, rowMetadata) -> new ExampleEntityDto.Response(
                                row.get("id", String.class),
                                row.get("name", String.class),
                                row.get("age", Integer.class),
                                row.get("birthdate", LocalDate.class) != null ?
                                        Date.valueOf(Objects.requireNonNull(row.get("birthdate", LocalDate.class))).getTime() :
                                        null,
                                row.get("balance", BigDecimal.class),
                                row.get("created_date", LocalDateTime.class) != null ?
                                        Timestamp.valueOf(Objects.requireNonNull(row.get("created_date", LocalDateTime.class))).getTime() :
                                        null
                        )
                )
                .all();
        return list;
    }
}
