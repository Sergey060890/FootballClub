package servlet.statsServlet;

import footballclub.entity.Player;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.StatsServiceImpl;
import managment.interfaces.PlayerService;
import managment.interfaces.StatsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/statsPlayer")
public class StatsPlayerServlet extends HttpServlet {
    public static final String ID = "id";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String STATS_JSP_PLAYER_STATS_JSP = "/stats-jsp/playerStats.jsp";


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StatsService statsService = new StatsServiceImpl();
        PlayerService playerService = new PlayerServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));//id player
        try {
            Player player = playerService.findPlayerById(id);
            if (player != null) {
                int countGamePlayer = statsService.statsPlayerCountAllGame(id);
                int countGameStart = statsService.statsPlayerCountStartGame(id);
                int countCoalPlayer = statsService.statsPlayerAllGoal(id);
                int countGoalConcededPlayer = statsService.statsGoalkeeperConcededGoal(id);
                int countYellowCardPlayer = statsService.statsYellowCard(id);
                int countRedCardPlayer = statsService.statsRedCard(id);
                request.setAttribute(ID, id);
                request.setAttribute("player", player);
                request.setAttribute("countGame", countGamePlayer);
                request.setAttribute("countStartGame", countGameStart);
                request.setAttribute("countGoalPlayer", countCoalPlayer);
                request.setAttribute("countGoalConcededPlayer", countGoalConcededPlayer);
                request.setAttribute("countYellowCardPlayer", countYellowCardPlayer);
                request.setAttribute("countRedCardPlayer", countRedCardPlayer);
                request.getServletContext().getRequestDispatcher(STATS_JSP_PLAYER_STATS_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (SQLException e) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
