package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.utils.SessionUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "anadirCarritoServlet")
public class InicioServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        if (!SessionUtils.getCarrito(session).isEmpty()) {
            response.sendRedirect(Routes.CARRITO);
        } else {
            response.sendRedirect(Routes.ANADIR_CARRITO);
        }
    }

    public void destroy() {
    }
}
