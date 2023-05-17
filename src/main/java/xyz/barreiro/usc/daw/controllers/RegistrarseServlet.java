package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.Routes;
import xyz.barreiro.usc.daw.models.CardType;
import xyz.barreiro.usc.daw.models.User;
import xyz.barreiro.usc.daw.models.repository.UserRepository;
import xyz.barreiro.usc.daw.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "registrarseServlet")
public class RegistrarseServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute(Constants.SESSION_ATTR__USER) != null) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/registrarse.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        String name = request.getParameter(Constants.REQUEST_ATTR__NAME);
        String email = request.getParameter(Constants.REQUEST_ATTR__EMAIL);
        String password = request.getParameter(Constants.REQUEST_ATTR__PASSWORD);
        CardType cardType = CardType.fromString(request.getParameter(Constants.REQUEST_ATTR__CARD_TYPE));
        String cardNumber = request.getParameter(Constants.REQUEST_ATTR__CARD_NUMBER);

        boolean created = UserRepository.createUser(name, email, password, cardType, cardNumber);
        if (created) {
            Optional<User> optionalUser = UserRepository.getUserByEmail(email);
            assert optionalUser.isPresent();
            session.setAttribute(Constants.SESSION_ATTR__USER, optionalUser.get());
            response.sendRedirect(Routes.PAGAR);
            return;
        }

        request.setAttribute(Constants.REQUEST_ATTR__ERROR, "Este usuario ya existe");
        this.doGet(request, response);
    }

    public void destroy() {
    }
}
