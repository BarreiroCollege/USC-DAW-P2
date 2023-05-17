package xyz.barreiro.usc.daw;

public final class Routes {
    public final static String ANADIR_CARRITO = "anadir-carrito";
    public final static String CARRITO = "carrito";
    public final static String ELIMINAR_CARRITO = "eliminar-carrito";
    public final static String PAGAR = "pagar";

    public String getAnadirCarrito() {
        return ANADIR_CARRITO;
    }

    public String getEliminarCarrito() {
        return ELIMINAR_CARRITO;
    }

    public String getPagar() {
        return PAGAR;
    }
}
