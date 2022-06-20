package servlet.statsServlet;

import footballclub.entity.Team;
import managment.implementation.GameServiceImpl;
import managment.implementation.StatsServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.StatsService;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(StatsTeamServlet.STATS_TEAM)
public class StatsTeamServlet extends HttpServlet {
    public static final String ID = "id";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String STATS_JSP_TEAM_STATS_JSP = "/stats-jsp/teamStats.jsp";
    public static final String TEAM = "team";
    public static final String SET_GAME = "setGame";
    public static final String COUNT_GAME = "countGame";
    public static final String COUNT_WIN_GAME = "countWinGame";
    public static final String COUNT_DRAW_GAME = "countDrawGame";
    public static final String COUNT_LOSE_GAME = "countLoseGame";
    public static final String COUNT_GOAL_SCORE = "countGoalScore";
    public static final String COUNT_GOAL_CONCEDED = "countGoalConceded";
    public static final String COUNT_YELLOW_CARD = "countYellowCard";
    public static final String COUNT_RED_CARD = "countRedCard";
    public static final String STATS_TEAM = "/statsTeam";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StatsService statsService = new StatsServiceImpl();
        GameService gameService = new GameServiceImpl();
        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));//id team
        try {
            Team team = teamService.findTeamId(id);
            if (team != null) {
                int countGame = statsService.statsTeamCountGame(id);
                int countWinGame = statsService.statsTeamWinGame(id);
                int countDrawGame = statsService.statsTeamDrawGame(id);
                int countLoseGame = statsService.statsTeamLoseGame(id);
                int countGoalScore = statsService.statsTeamGoalScore(id);
                int countGoalConceded = statsService.statsTeamGoalConc(id);
                int countYellowCard = statsService.statsTeamYellowCard(id);
                int countRedCard = statsService.statsTeamRedCard(id);
                request.setAttribute(ID, id);
                request.setAttribute(TEAM,team);
                request.setAttribute(COUNT_GAME,countGame);
                request.setAttribute(COUNT_WIN_GAME,countWinGame);
                request.setAttribute(COUNT_DRAW_GAME,countDrawGame);
                request.setAttribute(COUNT_LOSE_GAME,countLoseGame);
                request.setAttribute(COUNT_GOAL_SCORE,countGoalScore);
                request.setAttribute(COUNT_GOAL_CONCEDED,countGoalConceded);
                request.setAttribute(COUNT_YELLOW_CARD,countYellowCard);
                request.setAttribute(COUNT_RED_CARD,countRedCard);
                request.getServletContext().getRequestDispatcher(STATS_JSP_TEAM_STATS_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (SQLException e) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
