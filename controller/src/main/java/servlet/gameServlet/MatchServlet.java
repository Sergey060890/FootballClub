package servlet.gameServlet;

import footballclub.entity.Result;
import managment.implementation.GameServiceImpl;
import managment.implementation.ResultServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.ResultService;

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
    public static final String ATTENDANCE = "attendance";
    public static final String REFEREE = "referee";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameService gameService = new GameServiceImpl();
        ResultService resultService = new ResultServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));//id game
        int attendance = gameService.countAttendance();
        String referee = gameService.refereeGame();
        request.setAttribute(ID, id);

        try {
            Result result = resultService.findResultById(id);
            if (result != null) {
                request.setAttribute(GAME, result);
                request.setAttribute(ATTENDANCE,attendance);
                request.setAttribute(REFEREE,referee);
                request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
            }
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_MATCH_JSP).forward(request, response);
        }
    }
}

