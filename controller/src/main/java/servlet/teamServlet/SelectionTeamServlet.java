package servlet.teamServlet;

import DTO.TeamDTO;
import footballclub.entity.Game;
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

@WebServlet("/selection")
public class SelectionTeamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
            TeamDTO teamDTO = teamService.findTeamById(id);
            Set<Player> players = teamService.showAllPlayerTeamInfo(id);
            Set<Game> games = teamDTO.getGames();
            if(teamDTO!=null) {
                request.getServletContext().getRequestDispatcher("/team-jsp/myTeam.jsp").forward(request, response);
            }
            else {
                request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }
}
