package com.maryanto.dimas.example.utils;

import reactor.core.publisher.Mono;

import java.io.Serializable;

public interface DaoReactiveDataTablesPattern<T, ID extends Serializable> {

    Mono<T> findId(ID var1);

    Mono<T> save(T var1);

    Mono<T> update(T var1);

    Mono<Integer> removeById(ID var1);
}
