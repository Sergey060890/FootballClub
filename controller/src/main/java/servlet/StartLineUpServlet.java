package servlet;

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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/startLineup")
public class StartLineUpServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);//id игры

        try {
            Game game = gameService.findGameById(id);
            Set<Player> players = teamService.showAllPlayerTeamInfo(game.getTeamGame().getTeam_id());
            if (game != null) {
                request.setAttribute("game", game);
                request.setAttribute("players", players);
                request.getServletContext().getRequestDispatcher("/startLineup.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GameService gameService = new GameServiceImpl();
            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findGameById(id);
            String[] players = request.getParameterValues("player");
            Set<String> mySet = new HashSet<>(Arrays.asList(players));
            request.setAttribute("id", id);//id игры
            Set<Player> playerSet = teamService.showAllPlayerTeamInfo(game.getTeamGame().getTeam_id());

            Set<Player> playersGo = new HashSet<>();//вынести всё в метод
            for (Player player: playerSet
                 ) {
                for (String str:mySet
                     ) {
                    if (player.getPlayer_surname()==str){
                        playersGo.add(player);
                    }
                }
            }
            game.setPlayers(playersGo);
            response.sendRedirect(request.getContextPath() + "/goPlayers");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
