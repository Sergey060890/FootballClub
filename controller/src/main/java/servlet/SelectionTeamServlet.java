package servlet;

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
            TeamDTO teamDTO = teamService.findTeamById(id);
            Set<Player> players = teamService.showAllPlayerTeamInfo(id);
            Set<Game> games = teamDTO.getGames();
            if(teamDTO!=null) {
                String team_name = teamDTO.getTeam_name();
                String teamCity = teamDTO.getCity();
                String teamCountry = teamDTO.getCountry();
                String teamStadium = teamDTO.getStadium();
                String teamCoach = teamDTO.getCoach();

                request.setAttribute("players", players);
                request.setAttribute("games", games);

                request.setAttribute("product", teamDTO);
                request.setAttribute("name", team_name);
                request.setAttribute("city", teamCity);
                request.setAttribute("country", teamCountry);
                request.setAttribute("stadium", teamStadium);
                request.setAttribute("coach", teamCoach);

                request.getServletContext().getRequestDispatcher("/teamSelection.jsp").forward(request, response);
            }
            else {
                request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
