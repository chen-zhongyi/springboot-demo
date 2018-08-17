package com.example.demo.vos;

import com.example.demo.models.person.Person;

public class PersonVO extends OneData {

    private Long personId;
    private String name;
    private String phone;

    public PersonVO() {}

    public PersonVO(Person person) {
        this.personId = person.getId();
        this.name = person.getName();
        this.phone = person.getPhone();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

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
}
