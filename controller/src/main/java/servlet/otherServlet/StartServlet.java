package servlet.otherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(StartServlet.START_SERVLET)
public class StartServlet extends HttpServlet {

    public static final String START_SERVLET = "/StartServlet";
    public static final String OTHER_JSP_INDEX_JSP = "/other-jsp/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(OTHER_JSP_INDEX_JSP).forward(req, resp);
    }
}

