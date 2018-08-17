package com.example.demo.dao.person;

import com.example.demo.dao.BaseRepository;
import com.example.demo.models.person.Person;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends BaseRepository<Person> {

    @Query("from Person where deleted = false and phone = ?1")
    Person findByPhone(String phone);

}
