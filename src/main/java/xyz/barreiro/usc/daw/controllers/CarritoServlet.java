package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.utils.Constants;
import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("unchecked")
@WebServlet(name = "carritoServlet")
public class CarritoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        HashMap<CD, Integer> carrito;
        if (session.getAttribute(Constants.SESSION_ATTR__CARRITO) == null) {
            carrito = new HashMap<>();
        } else {
            carrito = (HashMap<CD, Integer>) session.getAttribute(Constants.SESSION_ATTR__CARRITO);
        }

        if (carrito.isEmpty()) {
            response.sendRedirect(Routes.ANADIR_CARRITO);
            return;
        }

        double total = 0.;
        for (Map.Entry<CD, Integer> entry : carrito.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        request.setAttribute(Constants.SESSION_ATTR__CARRITO, carrito);
        request.setAttribute(Constants.REQUEST_ATTR__IMPORTE, total);

        request.getRequestDispatcher("/WEB-INF/carrito.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
