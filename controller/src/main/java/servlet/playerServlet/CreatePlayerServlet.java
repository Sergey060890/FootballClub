package servlet.playerServlet;

import footballclub.entity.Player;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.PlayerService;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet(CreatePlayerServlet.CREATE_PLAYER)
public class CreatePlayerServlet extends HttpServlet {

    public static final String CREATE_PLAYER = "/createPlayer";
    public static final String ID = "id";
    public static final String PLAYER_JSP_CREATE_PLAYER_JSP = "/player-jsp/createPlayer.jsp";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String CONTRARY = "contrary";
    public static final String AGE = "age";
    public static final String POSITION = "position";
    public static final String PLAYERS = "players";
    public static final String PLAYER_LINE_UP_ID = "/playerLineUp?id=";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);
        getServletContext().getRequestDispatcher(PLAYER_JSP_CREATE_PLAYER_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        PlayerService playerService = new PlayerServiceImpl();
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String country = request.getParameter(CONTRARY);
        Integer age1 = Integer.valueOf(request.getParameter(AGE));
        String position = request.getParameter(POSITION);

        Set<Player> players = teamService.showAllPlayerTeamInfo(id);
        request.setAttribute(ID, id);
        request.setAttribute(PLAYERS, players);

        Player player = playerService.createPlayer(name, surname, country, age1, position);
        try {
            teamService.addPlayerInTeam(player, teamService.findTeamId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + PLAYER_LINE_UP_ID + id);

    }
}


