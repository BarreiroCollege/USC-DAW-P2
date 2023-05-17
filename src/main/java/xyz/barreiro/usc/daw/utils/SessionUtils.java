package xyz.barreiro.usc.daw.utils;

import xyz.barreiro.usc.daw.models.CD;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class SessionUtils {
    public static HashMap<CD, Integer> getCarrito(HttpSession session) {
        HashMap<CD, Integer> carrito;

        if (session.getAttribute(Constants.SESSION_ATTR__CARRITO) == null) {
            carrito = new HashMap<>();
        } else {
            carrito = (HashMap<CD, Integer>) session.getAttribute(Constants.SESSION_ATTR__CARRITO);
        }

        return carrito;
    }

    public static double getTotalFromCarrito(HashMap<CD, Integer> carrito) {
        double total = 0.;
        for (Map.Entry<CD, Integer> entry : carrito.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
