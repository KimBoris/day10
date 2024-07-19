package org.example.fortune;

public enum FortuneTeller {
    INSTANCE;

    private String[] cards;

    FortuneTeller() {
        cards = new String[4];
        cards[0] = "대길";
        cards[1] = "소길";
        cards[2] = "소흉";
        cards[3] = "대흉";
    }

    public String getOne() {
        int idx = (int) (Math.random() * cards.length);

        return cards[idx];
    }
}
