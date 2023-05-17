package xyz.barreiro.usc.daw.models;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum CardType {
    CREDIT,
    DEBIT;

    public static CardType fromString(String ct) {
        switch (ct) {
            case "C":
                return CardType.CREDIT;
            case "D":
                return CardType.DEBIT;
        }

        throw new NotImplementedException();
    }

    public String getFancyName() {
        switch (this) {
            case CREDIT:
                return "Crédito";
            case DEBIT:
                return "Débito";
        }

        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        switch (this) {
            case CREDIT:
                return "C";
            case DEBIT:
                return "D";
        }

        throw new NotImplementedException();
    }
}
