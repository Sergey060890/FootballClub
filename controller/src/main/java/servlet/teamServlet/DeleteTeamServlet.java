package servlet.teamServlet;


import managment.implementation.GameServiceImpl;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.PlayerService;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteTeamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TeamService teamService = new TeamServiceImpl();
            GameService gameService = new GameServiceImpl();
            PlayerService playerService = new PlayerServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            teamService.deleteAllGameTeam(gameService, id);
            teamService.deleteAllPlayerTeam(teamService, playerService, id);
            teamService.deleteTeam(id);
            response.sendRedirect(request.getContextPath() + "/TeamServlet");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }
}
