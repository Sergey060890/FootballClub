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
import java.sql.SQLException;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeamService teamService = new TeamServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        try {
            TeamDTO teamDTO = teamService.findTeamById(id);
            String team_name = teamDTO.getTeam_name();
            String teamCity = teamDTO.getCity();
            String teamCountry = teamDTO.getCountry();
            String teamStadium = teamDTO.getStadium();
            String teamCoach = teamDTO.getCoach();

//            request.setAttribute("players", players);
//            request.setAttribute("games", games);
            request.setAttribute("name", team_name);
            request.setAttribute("city", teamCity);
            request.setAttribute("country", teamCountry);
            request.setAttribute("stadium", teamStadium);
            request.setAttribute("coach", teamCoach);

            request.getServletContext().getRequestDispatcher("/myTeam.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

