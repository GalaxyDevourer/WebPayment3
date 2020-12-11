package servlets;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clients")
class StartServlet extends HttpServlet {

    //private static final String PERSISTENCE_UNIT_NAME = "webpayment";
    //private static EntityManagerFactory managerFactory;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/panels/clients.xhtml");
        dispatcher.forward(request, response);
    }
}
