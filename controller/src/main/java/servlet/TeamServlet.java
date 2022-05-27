package servlet;

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

import static constans.Constans.*;

@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {

    private final TeamServiceImpl teamService = new TeamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        List<TeamDTO> teams = teamService.findAll();
        req.setAttribute("teams", teams);
        getServletContext().getRequestDispatcher("/team.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String action = req.getParameter(ACTION);
        switch (action) {
            case CASE_ADD_TEAM:
                createTeam(req, resp);
                break;
            case CASE_UPDATE_TEAM:
                updateTeam(req, resp);
                break;
            case CASE_DELETE_TEAM:
                deleteTeam(req, resp);
                break;
            default:
                resp.sendRedirect(TEAM_SERVLET);
        }
    }

    private void createTeam(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        String name = req.getParameter(TEAM_NAME);
        String city = req.getParameter(TEAM_CITY);
        String country = req.getParameter(TEAM_COUNTRY);
        String stadium = req.getParameter(TEAM_STADIUM);
        String coach = req.getParameter(TEAM_COACH);
        teamService.createTeam(name, city, country, stadium, coach);
        resp.sendRedirect(TEAM_SERVLET);
    }

    private void updateTeam(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Integer idTeam = Integer.parseInt(req.getParameter(ID_TEAM));
        String name = req.getParameter(TEAM_NAME);
        String city = req.getParameter(TEAM_CITY);
        String country = req.getParameter(TEAM_COUNTRY);
        String stadium = req.getParameter(TEAM_STADIUM);
        String coach = req.getParameter(TEAM_CITY);
//        teamService.updateTeam(idTeam, name, city, country, stadium, coach);
        resp.sendRedirect(TEAM_SERVLET);
    }

    private void deleteTeam(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int idTeam = Integer.parseInt(req.getParameter(ID_TEAM));
//        teamService.delateTeam(idTeam);
        resp.sendRedirect(TEAM_SERVLET);
    }
}
