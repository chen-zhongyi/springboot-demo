package com.example.demo.listeners;

import com.example.demo.models.BaseModel;

import javax.persistence.PreUpdate;

public class BaseModelListener {

    @PreUpdate
    public static void preUpdate(BaseModel baseModel) {
        baseModel.setUpdateTime(System.currentTimeMillis());
    }

}
