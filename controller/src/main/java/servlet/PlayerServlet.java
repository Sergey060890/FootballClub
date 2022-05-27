package servlet;

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

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Set<Player> players = teamService.showAllPlayerTeamInfo(id);
        request.setAttribute("players", players);
        request.getServletContext().getRequestDispatcher("/player.jsp").forward(request, response);

    }
}
