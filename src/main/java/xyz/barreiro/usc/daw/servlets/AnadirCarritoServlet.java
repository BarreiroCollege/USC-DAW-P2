package xyz.barreiro.usc.daw.servlets;

import xyz.barreiro.usc.daw.utils.Constants;
import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CD;
import xyz.barreiro.usc.daw.repository.CDRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;


@SuppressWarnings("unchecked")
@WebServlet(name = "anadirCarritoServlet")
public class AnadirCarritoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute(Constants.REQUEST_ATTR__CDS, CDRepository.getAllCds());
        request.getRequestDispatcher("/WEB-INF/anadir-carrito.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        HashMap<CD, Integer> carrito;
        if (session.getAttribute(Constants.SESSION_ATTR__CARRITO) == null) {
            carrito = new HashMap<>();
        } else {
            carrito = (HashMap<CD, Integer>) session.getAttribute(Constants.SESSION_ATTR__CARRITO);
        }

        Integer idCd = Integer.parseInt(request.getParameter(Constants.REQUEST_ATTR__ID_CD));
        Optional<CD> cdOptional = CDRepository.getCdById(idCd);
        if (!cdOptional.isPresent()) {
            return;
        }
        CD cd = cdOptional.get();

        Integer cantidad;
        try {
            int nuevaCantidad = Integer.parseInt(request.getParameter(Constants.REQUEST_ATTR__CANTIDAD));
            cantidad = Math.max(nuevaCantidad, 0);
        } catch (NullPointerException | NumberFormatException e) {
            return;
        }

        if (!carrito.containsKey(cd)) {
            carrito.put(cd, 0);
        }
        carrito.put(cd, carrito.get(cd) + cantidad);

        session.setAttribute(Constants.SESSION_ATTR__CARRITO, carrito);

        response.sendRedirect(Routes.CARRITO);
    }

    public void destroy() {
    }
}
