package com.example.demo.services.imp.person;

import com.example.demo.dao.person.CardRepository;
import com.example.demo.enums.CardType;
import com.example.demo.models.person.Card;
import com.example.demo.services.imp.BaseServiceImp;
import com.example.demo.services.person.CardService;
import com.example.demo.services.person.PersonService;
import com.example.demo.vos.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CardServiceImp extends BaseServiceImp<Card, CardVO> implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private PersonService personService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private void setBaseRepository() {
        setBaseRepository(cardRepository);
    }

    @Override
    public Card voToModel(CardVO vo) {
        Card card = new Card();
        card.setPerson(personService.info(vo.getPersonId()));
        return voToModel(card, vo);
    }

    @Override
    public Card voToModel(Card card, CardVO vo) {
        card.setNumber(vo.getNumber() != null ? vo.getNumber() : card.getNumber());
        card.setType(vo.getType() != null ? CardType.convert(vo.getType()) : card.getType());
        return card;
    }

}
