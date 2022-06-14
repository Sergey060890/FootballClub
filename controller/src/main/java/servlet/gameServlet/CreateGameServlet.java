package servlet.gameServlet;

import footballclub.entity.Team;
import managment.implementation.GameServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(CreateGameServlet.CREATE_GAME)
public class CreateGameServlet extends HttpServlet {

    public static final String CREATE_GAME = "/createGame";
    public static final String ID = "id";
    public static final String GAME_JSP_CREATE_GAME_JSP = "/game-jsp/createGame.jsp";
    public static final String OPPONENT = "opponent";
    public static final String GAME_ID = "/game?id=";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);
        getServletContext().getRequestDispatcher(GAME_JSP_CREATE_GAME_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            TeamService teamService = new TeamServiceImpl();
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            Team team =   teamService.findTeamId(id);
            String opponent = request.getParameter(OPPONENT);
            gameService.createGame(team,opponent);
            response.sendRedirect(request.getContextPath() + GAME_ID + id);
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }

}