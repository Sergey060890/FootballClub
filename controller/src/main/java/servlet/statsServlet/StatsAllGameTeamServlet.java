package servlet.statsServlet;

import footballclub.entity.Game;
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
import java.sql.SQLException;
import java.util.Set;

@WebServlet(StatsAllGameTeamServlet.STATS_ALL_GAME_TEAM)
public class StatsAllGameTeamServlet extends HttpServlet {
    public static final String ID = "id";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String TEAM = "team";
    public static final String SET_GAME = "setGame";
    public static final String STATS_JSP_TEAM_ALL_GAME_STATS_JSP
            = "/stats-jsp/teamAllGameStats.jsp";
    public static final String STATS_ALL_GAME_TEAM = "/statsAllGameTeam";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GameService gameService = new GameServiceImpl();
        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));//id team
        try {
            Team team = teamService.findTeamId(id);
            if (team != null) {
                Set<Game> gameSet = gameService.showAllGameTeamInfo(id);
                request.setAttribute(ID, id);
                request.setAttribute(TEAM,team);
                request.setAttribute(SET_GAME,gameSet);
                request.getServletContext().getRequestDispatcher(STATS_JSP_TEAM_ALL_GAME_STATS_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (SQLException e) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
