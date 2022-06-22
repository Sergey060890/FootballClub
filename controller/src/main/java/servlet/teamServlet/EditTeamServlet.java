package servlet.teamServlet;

import dto.TeamDTO;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(EditTeamServlet.EDIT)
public class EditTeamServlet extends HttpServlet {

    public static final String EDIT = "/edit";
    public static final String ID = "id";
    public static final String PRODUCT = "product";
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String STADIUM = "stadium";
    public static final String COACH = "coach";
    public static final String TEAM_JSP_EDIT_TEAM_JSP = "/team-jsp/editTeam.jsp";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String PLAYER_ID = "/player?id=";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            TeamDTO teamDTO = teamService.findTeamById(id);
            request.setAttribute(ID, id);
            if (teamDTO != null) {
                String team_name = teamDTO.getTeam_name();
                String teamCity = teamDTO.getCity();
                String teamCountry = teamDTO.getCountry();
                String teamStadium = teamDTO.getStadium();
                String teamCoach = teamDTO.getCoach();
                request.setAttribute(PRODUCT, teamDTO);
                request.setAttribute(NAME, team_name);
                request.setAttribute(CITY, teamCity);
                request.setAttribute(COUNTRY, teamCountry);
                request.setAttribute(STADIUM, teamStadium);
                request.setAttribute(COACH, teamCoach);

                request.getServletContext()
                        .getRequestDispatcher(TEAM_JSP_EDIT_TEAM_JSP).forward(request, response);
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

            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            String name = request.getParameter(NAME);
            String city = request.getParameter(CITY);
            String country = request.getParameter(COUNTRY);
            String stadium = request.getParameter(STADIUM);
            String coach = request.getParameter(COACH);

            teamService.updateTeam(id, name, city, country, stadium, coach);
            response.sendRedirect(request.getContextPath() + PLAYER_ID + id);
        } catch (Exception ex) {

            request.getServletContext()
                    .getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}

