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
import java.util.Set;

@WebServlet(GameServlet.GAME)
public class GameServlet extends HttpServlet {

    public static final String GAME = "/game";
    public static final String ID = "id";
    public static final String GAMES = "games";
    public static final String GAME_JSP_GAME_JSP = "/game-jsp/game.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));// id команды
        Set<Game> gameSet =
                gameService.showAllGameTeamInfo(id);
        request.setAttribute(ID, id);
        request.setAttribute(GAMES, gameSet);
        request.getServletContext().getRequestDispatcher(GAME_JSP_GAME_JSP).forward(request, response);
    }
}