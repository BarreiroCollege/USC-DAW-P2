package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CD;
import xyz.barreiro.usc.daw.models.Order;
import xyz.barreiro.usc.daw.models.OrderCD;
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
import java.util.Optional;


@WebServlet(name = "confirmacionCompraServlet")
public class ConfirmacionCompraServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        String possibleId = request.getParameter("id");
        if (possibleId == null) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(possibleId);
        } catch (NumberFormatException e) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }

        Optional<Order> optionalOrder = OrderRepository.getOrderById(id);
        if (!optionalOrder.isPresent()) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }
        Order order = optionalOrder.get();

        Object possibleUser = session.getAttribute(Constants.SESSION_ATTR__USER);
        if (possibleUser == null) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }
        User user = (User) possibleUser;
        if (!order.getUser().equals(user)) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }

        HashMap<CD, Integer> carrito = new HashMap<>();
        for (OrderCD orderCD : OrderRepository.getOrderCdsByOrder(order)) {
            carrito.put(orderCD.getCd(), orderCD.getAmount());
        }

        double total = SessionUtils.getTotalFromCarrito(carrito);

        request.setAttribute(Constants.SESSION_ATTR__CARRITO, carrito);
        request.setAttribute(Constants.REQUEST_ATTR__IMPORTE, total);

        request.getRequestDispatcher("/WEB-INF/confirmacionCompra.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
