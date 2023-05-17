package xyz.barreiro.usc.daw;

public class Routes {
    public final static String ANADIR_CARRITO = "anadir-carrito";
    public final static String CARRITO = "carrito";
    public final static String ELIMINAR_CARRITO = "eliminar-carrito";
    public final static String PAGAR = "pagar";

    public final String getAnadirCarrito() {
        return ANADIR_CARRITO;
    }

    public final String getEliminarCarrito() {
        return ELIMINAR_CARRITO;
    }

    public final String getPagar() {
        return PAGAR;
    }
}
