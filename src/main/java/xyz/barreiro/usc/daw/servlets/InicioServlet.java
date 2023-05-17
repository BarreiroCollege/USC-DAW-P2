package xyz.barreiro.usc.daw.servlets;

import xyz.barreiro.usc.daw.Routes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "anadirCarritoServlet")
public class InicioServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(Routes.ANADIR_CARRITO);
    }

    public void destroy() {
    }
}
