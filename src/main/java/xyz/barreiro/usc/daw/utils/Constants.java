package xyz.barreiro.usc.daw.utils;

public final class Constants {
    public final static String SESSION_ATTR__CARRITO = "carrito";
    public final static String SESSION_ATTR__USER = "user";

    public final static String REQUEST_ATTR__CDS = "cds";
    public final static String REQUEST_ATTR__ID_CD = "input-cd";
    public final static String REQUEST_ATTR__CANTIDAD = "input-cantidad";
    public final static String REQUEST_ATTR__NAME = "input-name";
    public final static String REQUEST_ATTR__EMAIL = "input-email";
    public final static String REQUEST_ATTR__PASSWORD = "input-password";
    public final static String REQUEST_ATTR__CARD_TYPE = "input-card-type";
    public final static String REQUEST_ATTR__CARD_NUMBER = "input-card-number";
    public final static String REQUEST_ATTR__IMPORTE = "importe";
    public final static String REQUEST_ATTR__ERROR = "error";


    public String getInputIdCd() {
        return REQUEST_ATTR__ID_CD;
    }

    public String getInputCantidad() {
        return REQUEST_ATTR__CANTIDAD;
    }

    public String getInputName() {
        return REQUEST_ATTR__NAME;
    }

    public String getInputEmail() {
        return REQUEST_ATTR__EMAIL;
    }

    public String getInputPassword() {
        return REQUEST_ATTR__PASSWORD;
    }

    public String getInputCardType() {
        return REQUEST_ATTR__CARD_TYPE;
    }

    public String getInputCardNumber() {
        return REQUEST_ATTR__CARD_NUMBER;
    }

    public String getError() {
        return REQUEST_ATTR__ERROR;
    }
}
