package xyz.barreiro.usc.daw.models;

import java.util.Objects;

public class Order {
    private final Integer id;
    private final User user;
    private final Double price;

    public Order(Integer id, User user, Double price) {
        this.id = id;
        this.user = user;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
