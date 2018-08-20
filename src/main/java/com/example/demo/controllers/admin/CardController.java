package com.example.demo.controllers.admin;

import com.example.demo.models.person.Card;
import com.example.demo.services.person.CardService;
import com.example.demo.vos.CardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card add(@RequestBody CardVO vo) {
        Card card = cardService.add(vo);
        return card;
    }

}
