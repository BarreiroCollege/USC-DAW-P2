package xyz.barreiro.usc.daw;

public class Constants {
    public final static String SESSION_ATTR__CARRITO = "carrito";

    public final static String REQUEST_ATTR__ID_CD = "input-cd";
    public final static String REQUEST_ATTR__CANTIDAD = "input-cantidad";
    public final static String REQUEST_ATTR__IMPORTE = "importe";


    public final String getInputIdCd() {
        return REQUEST_ATTR__ID_CD;
    }

    public final String getInputCantidad() {
        return REQUEST_ATTR__CANTIDAD;
    }
}
