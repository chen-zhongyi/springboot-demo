package com.example.demo.enums;

import java.util.Arrays;

public enum CardType {

    ID_CARD(100, "省份证"),
    BANK(101, "银行卡");

    private int code;
    private String intro;

    private CardType(int code, String intro) {
        this.code = code;
        this.intro = intro;
    }

    public static CardType convert(Integer code) {
        if (code == null) {
            return null;
        }
        return Arrays.stream(CardType.values()).filter(c -> c.code() == code).findFirst().orElse(null);
    }

    public int code() {
        return this.code;
    }

    public String intro() {
        return this.intro;
    }

}
