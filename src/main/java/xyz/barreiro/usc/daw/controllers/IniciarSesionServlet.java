package xyz.barreiro.usc.daw.controllers;

import xyz.barreiro.usc.daw.Routes;
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


@WebServlet(name = "iniciarSesionServlet")
public class IniciarSesionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute(Constants.SESSION_ATTR__USER) != null) {
            response.sendRedirect(Routes.CARRITO);
            return;
        }

        request.getRequestDispatcher("/WEB-INF/iniciarSesion.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();

        String email = request.getParameter(Constants.REQUEST_ATTR__EMAIL);
        String password = request.getParameter(Constants.REQUEST_ATTR__PASSWORD);

        Optional<User> optionalUser = UserRepository.getUserByEmailAndPassword(email, password);
        if (optionalUser.isPresent()) {
            session.setAttribute(Constants.SESSION_ATTR__USER, optionalUser.get());
            response.sendRedirect(Routes.PAGAR);
            return;
        }

        request.setAttribute(Constants.REQUEST_ATTR__ERROR, "Credenciales Inválidas");
        this.doGet(request, response);
    }

    public void destroy() {
    }
}
