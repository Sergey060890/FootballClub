package servlet.gameServlet;

import footballclub.entity.Game;
import managment.implementation.GameServiceImpl;
import managment.interfaces.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(MatchServlet.MATCH)
public class MatchServlet extends HttpServlet {

    public static final String MATCH = "/match";
    public static final String ID = "id";
    public static final String GAME = "game";
    public static final String OTHER_JSP_MATCH_JSP = "/other-jsp/match.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);

        try {
            Game game = gameService.findGameById(id);
            if (game != null) {
                request.setAttribute(GAME, game);
                request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
        }
    }
}

