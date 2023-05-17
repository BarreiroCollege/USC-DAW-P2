package xyz.barreiro.usc.daw.servlets;

import xyz.barreiro.usc.daw.Constants;
import xyz.barreiro.usc.daw.Data;
import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CD;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


@SuppressWarnings("unchecked")
@WebServlet(name = "eliminarCarritoServlet")
public class EliminarCarritoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        HashMap<CD, Integer> carrito;
        if (session.getAttribute(Constants.SESSION_ATTR__CARRITO) == null) {
            carrito = new HashMap<>();
        } else {
            carrito = (HashMap<CD, Integer>) session.getAttribute(Constants.SESSION_ATTR__CARRITO);
        }

        String idCd = request.getParameter(Constants.REQUEST_ATTR__ID_CD);
        if (idCd == null) {
            return;
        }
        CD cd = Data.getCdById(idCd);
        if (cd == null) {
            return;
        }

        carrito.remove(cd);

        response.sendRedirect(Routes.CARRITO);
    }

    public void destroy() {
    }
}
