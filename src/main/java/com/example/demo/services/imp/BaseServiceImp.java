package com.example.demo.services.imp;

import com.example.demo.dao.BaseRepository;
import com.example.demo.models.BaseModel;
import com.example.demo.services.BaseService;
import com.example.demo.vos.OneData;
import com.querydsl.core.types.OrderSpecifier;

import java.util.List;

public class BaseServiceImp<T extends BaseModel, E extends OneData> implements BaseService<T, E> {

    private BaseRepository<T> baseRepository;

    public void setBaseRepository(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T voToModel(E e) {
        return null;
    }

    public T voToModel(T t, E e) {
        return null;
    }

    public T add(E e) {
        T t = voToModel(e);
        return baseRepository.save(voToModel(t, e));
    }

    public T edit(Long id, E e) {
        T t = baseRepository.findByID(id);
        t.setUpdateTime(System.currentTimeMillis());
        return baseRepository.save(voToModel(t, e));
    }

    public T info(Long id) {
        return baseRepository.findByID(id);
    }

    public void logicDelete(Long id) {
        T t = baseRepository.findByID(id);
        if (t != null) {
            t.setDeleted(true);
            t.setUpdateTime(System.currentTimeMillis());
            baseRepository.save(t);
        }
    }

    public List<T> fetchAll() {
        return baseRepository.fetchAll();
    }

    public List<T> fetch(E e, OrderSpecifier[] orderSpecifiers) {
        return fetchAll();
    }

    public int count(E e) {
        return fetchAll().size();
    }

}
