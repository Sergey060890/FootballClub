package servlet.playerServlet;

import footballclub.entity.Player;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(PlayerLineUpServlet.PLAYER_LINE_UP)
public class PlayerLineUpServlet extends HttpServlet {

    public static final String PLAYER_LINE_UP = "/playerLineUp";
    public static final String ID = "id";
    public static final String PLAYERS = "players";
    public static final String PLAYER_JSP_PLAYER_JSP = "/player-jsp/player.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        Set<Player> players = teamService.showAllPlayerTeamInfo(id);
        request.setAttribute(ID, id);
        request.setAttribute(PLAYERS, players);
        request.getServletContext().getRequestDispatcher(PLAYER_JSP_PLAYER_JSP).forward(request, response);
    }
}