package com.example.demo.controllers.admin;

import com.example.demo.models.person.Person;
import com.example.demo.models.person.QPerson;
import com.example.demo.services.person.PersonService;
import com.example.demo.vos.PersonVO;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/person")
public class PersonController{

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> list() {
        QPerson person = QPerson.person;
        OrderSpecifier[] orders = new OrderSpecifier[] {person.name.desc(), person.id.asc()};
        PersonVO vo = new PersonVO();
        //vo.setName("chen h");
        return personService.fetch(vo, orders);
    }

    @PostMapping
    public void add(@RequestBody PersonVO vo) {
        personService.add(vo);
    }

    @PutMapping("/{id}")
    public void edit(@RequestBody PersonVO vo, @PathVariable Long id) {
        personService.edit(id, vo);
    }

    @GetMapping("/{id}")
    public Person info(@PathVariable Long id) {
        return personService.info(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.logicDelete(id);
    }

}
