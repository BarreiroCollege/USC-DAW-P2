package xyz.barreiro.usc.daw.models;

import java.util.Objects;

public class User {
    private final Integer id;
    private final String name;
    private final String email;
    private final CardType cardType;
    private final String cardNumber;

    public User(Integer id, String name, String email, CardType cardType, String cardNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CardType getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
