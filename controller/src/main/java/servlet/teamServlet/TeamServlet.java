package servlet.teamServlet;

import DTO.TeamDTO;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(TeamServlet.TEAM_SERVLET)
public class TeamServlet extends HttpServlet {

    public static final String TEAM_SERVLET = "/TeamServlet";
    public static final String TEAMS = "teams";
    public static final String TEAM_JSP_TEAM_JSP = "/team-jsp/team.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        List<TeamDTO> teams = teamService.findAll();
        req.setAttribute(TEAMS, teams);
        getServletContext().getRequestDispatcher(TEAM_JSP_TEAM_JSP).forward(req, resp);
    }


}
