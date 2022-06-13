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
import java.util.Map;
import java.util.Set;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Set<Game> gameSet =
                gameService.showAllGameTeamInfo(id);
        Map<Integer,String> games =
                gameService.showAllOpponentTeamInfo(gameSet);
        request.setAttribute("id", id);
        request.setAttribute("games", games);
        request.getServletContext().getRequestDispatcher("/game-jsp/game.jsp").forward(request, response);
    }
}