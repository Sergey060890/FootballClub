package servlet.playerServlet;

import footballclub.entity.Game;
import footballclub.entity.Player;
import managment.implementation.GameServiceImpl;
import managment.interfaces.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet("/goPlayers")
public class GoPlayersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findGameById(id);
            Set<Player> players = game.getPlayers();
            request.setAttribute("id", id);
            request.setAttribute("players", players);
            request.getServletContext().getRequestDispatcher("/player-jsp/goPlayer.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
