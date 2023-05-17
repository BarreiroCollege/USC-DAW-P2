package xyz.barreiro.usc.daw.models;

import java.util.Objects;

public class OrderCD {
    private final Integer id;
    private final Order order;
    private final CD cd;
    private final Integer amount;

    public OrderCD(Integer id, Order order, CD cd, Integer amount) {
        this.id = id;
        this.order = order;
        this.cd = cd;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public CD getCd() {
        return cd;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCD orderCD = (OrderCD) o;
        return Objects.equals(id, orderCD.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
