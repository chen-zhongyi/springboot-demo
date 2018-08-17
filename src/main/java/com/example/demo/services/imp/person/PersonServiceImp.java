package com.example.demo.services.imp.person;

import com.example.demo.dao.person.PersonRepository;
import com.example.demo.models.person.Person;
import com.example.demo.models.person.QPerson;
import com.example.demo.services.imp.BaseServiceImp;
import com.example.demo.services.person.PersonService;
import com.example.demo.vos.PersonVO;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class PersonServiceImp extends BaseServiceImp<Person, PersonVO> implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private void setBaseRepository() {
        setBaseRepository(personRepository);
    }

    @Override
    public Person voToModel(PersonVO vo) {
        Person person = new Person();
        person.setPhone(vo.getPhone());
        return voToModel(person, vo);
    }

    @Override
    public Person voToModel(Person person, PersonVO vo) {
        person.setName(vo.getName() != null ? vo.getName() : person.getName());
        return person;
    }

    public boolean isExist(String phone) {
        return personRepository.findByPhone(phone) != null;
    }

    public void logicDelete(Long id) {
        super.logicDelete(id);
    }

    public List<Person> fetch(PersonVO vo, OrderSpecifier[] orderSpecifiers) {
        JPAQuery query = new JPAQuery(entityManager);
        query.select(QPerson.person).from(QPerson.person).where(booleanExpressions(vo)).orderBy(orderSpecifiers);
        return query.fetch();
    }

    public int count(PersonVO vo) {
        JPAQuery query = new JPAQuery(entityManager);
        query.from(QPerson.person).where(booleanExpressions(vo));
        return (int) query.fetchCount();
    }

    private BooleanExpression booleanExpressions(PersonVO vo) {
        QPerson person = QPerson.person;
        BooleanExpression expression = person.deleted.eq(false);
        if (StringUtils.isNotBlank(vo.getName())) {
            expression = expression.and(person.name.like("%" + vo.getName() + "%"));
        }
        if (StringUtils.isNotBlank(vo.getPhone())) {
            expression = expression.and(person.phone.eq(vo.getPhone()));
        }
        if (vo.getCreateTime() != null) {
            expression = expression.and(person.createTime.lt(1L));
        }
        return expression;
    }

}
