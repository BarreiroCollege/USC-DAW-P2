package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CD;
import xyz.barreiro.usc.daw.models.Order;
import xyz.barreiro.usc.daw.models.User;
import xyz.barreiro.usc.daw.models.repository.OrderRepository;
import xyz.barreiro.usc.daw.utils.Constants;
import xyz.barreiro.usc.daw.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@WebServlet(name = "pagarServlet")
public class PagarServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        HashMap<CD, Integer> carrito = SessionUtils.getCarrito(session);
        if (carrito.isEmpty()) {
            response.sendRedirect(Routes.ANADIR_CARRITO);
            return;
        }

        double total = SessionUtils.getTotalFromCarrito(carrito);

        request.setAttribute(Constants.REQUEST_ATTR__IMPORTE, total);

        request.getRequestDispatcher("/WEB-INF/pagar.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        Object possibleUser = session.getAttribute(Constants.SESSION_ATTR__USER);
        if (possibleUser == null) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }
        User user = (User) possibleUser;
        HashMap<CD, Integer> carrito = SessionUtils.getCarrito(session);

        double total = SessionUtils.getTotalFromCarrito(carrito);
        OrderRepository.createOrder(user, total);
        Optional<Order> optionalOrder = OrderRepository.getLastOrderFromUser(user);
        assert optionalOrder.isPresent();
        Order order = optionalOrder.get();

        for (Map.Entry<CD, Integer> entry : carrito.entrySet()) {
            OrderRepository.createOrderCd(order, entry.getKey(), entry.getValue());
        }

        session.setAttribute(Constants.SESSION_ATTR__CARRITO, new HashMap<>());
        response.sendRedirect(Routes.CONFIRMACION_COMPRA + "?id=" + order.getId());
    }

    public void destroy() {
    }
}
