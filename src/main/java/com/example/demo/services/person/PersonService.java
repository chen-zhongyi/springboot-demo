package com.example.demo.services.person;

import com.example.demo.models.person.Person;
import com.example.demo.services.BaseService;
import com.example.demo.vos.PersonVO;

public interface PersonService extends BaseService<Person, PersonVO> {

    boolean isExist(String phone);

}
