package servlet.playerServlet;

import footballclub.entity.Game;
import footballclub.entity.Player;
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
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@WebServlet("/startLineup")
public class StartLineUpServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);//id команды

        try {
            Game game = gameService.findGameById(id);
            Set<Player> players1 = teamService.showAllPlayerTeamInfo(game.getTeamGame().getTeam_id());
            if (game != null) {
                request.setAttribute("game", game);
                request.setAttribute("players", players1);
                request.getServletContext().getRequestDispatcher("/player-jsp/startLineup.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
            String[] players = request.getParameterValues("player");
            Set<Player> playersGo = gameService.startGamePlayer(id, players);
            Set<Player> playersNoGo = gameService.noStartGamePlayer(id, players);
            Game game = gameService.findGameById(id);
            List<String> info = gameService.showGameAndStats(gameService, game, playersGo, playersNoGo);
            request.setAttribute("id", id);
//            request.setAttribute("playersGo", playersGo);
//            request.setAttribute("playersNoGo", playersNoGo);
            request.setAttribute("game", game);
//            request.setAttribute("players", players);
            request.setAttribute("info", info);
//            Set<Game> gameSet =
//                    gameService.showAllGameTeamInfo(game.getTeamGame().getTeam_id());
//            gameService.opponentRemoveTeam(gameService,game,gameSet);
            request.getServletContext().getRequestDispatcher("/player-jsp/goPlayer.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
