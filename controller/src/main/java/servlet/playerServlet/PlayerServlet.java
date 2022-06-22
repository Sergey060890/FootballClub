package servlet.playerServlet;

import dto.TeamDTO;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(PlayerServlet.PLAYER)
public class PlayerServlet extends HttpServlet {

    public static final String PLAYER = "/player";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String STADIUM = "stadium";
    public static final String COACH = "coach";
    public static final String TEAM_JSP_MY_TEAM_JSP = "/team-jsp/myTeam.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);
        try {
            TeamDTO teamDTO = teamService.findTeamById(id);
            String team_name = teamDTO.getTeam_name();
            String teamCity = teamDTO.getCity();
            String teamCountry = teamDTO.getCountry();
            String teamStadium = teamDTO.getStadium();
            String teamCoach = teamDTO.getCoach();

//            request.setAttribute("players", players);
//            request.setAttribute("games", games);
            request.setAttribute(NAME, team_name);
            request.setAttribute(CITY, teamCity);
            request.setAttribute(COUNTRY, teamCountry);
            request.setAttribute(STADIUM, teamStadium);
            request.setAttribute(COACH, teamCoach);

            request.getServletContext().getRequestDispatcher(TEAM_JSP_MY_TEAM_JSP).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

