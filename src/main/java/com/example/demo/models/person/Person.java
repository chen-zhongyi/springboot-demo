package com.example.demo.models.person;

import com.example.demo.models.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BaseModel {

    @Column(columnDefinition = STRING + "'名称'")
    private String name;
    @Column(columnDefinition = STRING + "'手机号'")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
