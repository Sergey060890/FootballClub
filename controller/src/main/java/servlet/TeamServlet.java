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


@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        List<TeamDTO> teams = teamService.findAll();
        req.setAttribute("teams", teams);
        getServletContext().getRequestDispatcher("/team.jsp").forward(req, resp);
    }

}
