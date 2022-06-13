package servlet.teamServlet;

import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(CreateTeamServlet.CREATE)
public class CreateTeamServlet extends HttpServlet {

    public static final String CREATE = "/create";
    public static final String TEAM_JSP_CREATE_TEAM_JSP = "/team-jsp/createTeam.jsp";
    public static final String NAME = "name";
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String STADIUM = "stadium";
    public static final String COACH = "coach";
    public static final String TEAM_SERVLET = "/TeamServlet";
    public static final String TEAM_JSP_CREATE_TEAM_JSP1 = "/team-jsp/createTeam.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher(TEAM_JSP_CREATE_TEAM_JSP).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TeamService teamService = new TeamServiceImpl();

            String name = request.getParameter(NAME);
            String city = request.getParameter(CITY);
            String country = request.getParameter(COUNTRY);
            String stadium = request.getParameter(STADIUM);
            String coach = request.getParameter(COACH);

            teamService.createTeam(name, city, country, stadium, coach);
            response.sendRedirect(request.getContextPath() + TEAM_SERVLET);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher(TEAM_JSP_CREATE_TEAM_JSP1).forward(request, response);
        }
    }
}

