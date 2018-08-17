package com.example.demo.services;

import com.example.demo.models.BaseModel;
import com.example.demo.vos.OneData;
import com.querydsl.core.types.OrderSpecifier;

import java.util.List;

public interface BaseService<T extends BaseModel, E extends OneData> {

    T voToModel(E e);

    T voToModel(T t, E e);

    T add(E e);

    T edit(Long id, E e);

    T info(Long id);

    void logicDelete(Long id);

    List<T> fetchAll();

    List<T> fetch(E e, OrderSpecifier[] orderSpecifiers);

    int count(E e);

}
