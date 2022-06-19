package servlet.playerServlet;

import footballclub.entity.Game;
import footballclub.entity.Player;
import footballclub.entity.Result;
import managment.implementation.GameServiceImpl;
import managment.implementation.ResultServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.ResultService;
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

@WebServlet(StartLineUpServlet.START_LINEUP)
public class StartLineUpServlet extends HttpServlet {

    public static final String START_LINEUP = "/startLineup";
    public static final String ID = "id";
    public static final String GAME = "game";
    public static final String PLAYERS = "players";
    public static final String PLAYER_JSP_START_LINEUP_JSP = "/player-jsp/startLineup.jsp";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String PLAYER = "player";
    public static final String INFO = "info";
    public static final String PLAYER_JSP_GO_PLAYER_JSP = "/player-jsp/goPlayer.jsp";
    public static final int INT = 11;
    public static final String START_LINEUP_ID = "/startLineup?id=";
    public static final int INT1 = 0;
    public static final int INT2 = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        ResultService resultService = new ResultServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));//id игры
        request.setAttribute(ID, id);//id игры

        try {
            Result result = resultService.findResultById(id);
            Set<Player> players1 = teamService.showAllPlayerTeamInfo(result.getTeamGame().getTeam_id());
            if (result != null) {
                request.setAttribute(GAME, result);
                request.setAttribute(PLAYERS, players1);
                request.getServletContext()
                        .getRequestDispatcher(PLAYER_JSP_START_LINEUP_JSP).forward(request, response);
            } else {
                request.getServletContext()
                        .getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (Exception ex) {
            request.getServletContext()
                    .getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            GameService gameService = new GameServiceImpl();
            ResultService resultService = new ResultServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));//ID игры
            Result result = resultService.findResultById(id);
            String[] players = request.getParameterValues(PLAYER);
            request.setAttribute(ID, id);
            if (players.length < INT || players.length > INT) {
                response.sendRedirect(request.getContextPath() + START_LINEUP_ID + id);
            } else {
                Set<Player> playersGo = gameService.
                        startGamePlayer(result.getTeamGame().getTeam_id(), players);
                if (gameService.goalkeeperСheck(playersGo) == INT1
                        || gameService.goalkeeperСheck(playersGo) > INT2) {
                    response.sendRedirect(request.getContextPath() + START_LINEUP_ID + id);
                } else {
                    Game game = gameService.createGame(result.getTeamGame(),result.getOpponent_name());
                    Set<Player> playersNoGo = gameService.
                            noStartGamePlayer(result.getTeamGame().getTeam_id(), players);
                    List<String> info = gameService.
                            showGameAndStats(gameService, game, playersGo, playersNoGo);
                    request.setAttribute(PLAYERS, playersGo);
                    request.setAttribute(GAME, game);
                    request.setAttribute(INFO, info);
                    resultService.deleteResult(id);
                    request.getServletContext()
                            .getRequestDispatcher(PLAYER_JSP_GO_PLAYER_JSP).forward(request, response);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
