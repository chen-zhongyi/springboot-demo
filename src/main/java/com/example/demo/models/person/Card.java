package com.example.demo.models.person;

import com.example.demo.enums.CardType;
import com.example.demo.models.BaseModel;

import javax.persistence.*;

@Entity
public class Card extends BaseModel {

    @ManyToOne
    private Person person;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = STRING + "'卡类型'")
    private CardType type;
    @Column(columnDefinition = STRING + "'卡号'")
    private String number;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card{" +
                "person=" + person +
                ", type=" + type +
                ", number='" + number + '\'' +
                '}';
    }
}
