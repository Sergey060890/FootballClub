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

@WebServlet("/edit")
public class EditTeamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            TeamDTO teamDTO = teamService.findTeamById(id);
            request.setAttribute("id", id);
            if(teamDTO!=null) {
                String team_name = teamDTO.getTeam_name();
                String teamCity = teamDTO.getCity();
                String teamCountry = teamDTO.getCountry();
                String teamStadium = teamDTO.getStadium();
                String teamCoach = teamDTO.getCoach();
                request.setAttribute("product", teamDTO);
                request.setAttribute("name", team_name);
                request.setAttribute("city", teamCity);
                request.setAttribute("country", teamCountry);
                request.setAttribute("stadium", teamStadium);
                request.setAttribute("coach", teamCoach);

                request.getServletContext().getRequestDispatcher("/team-jsp/editTeam.jsp").forward(request, response);
            }
            else {
                request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String stadium = request.getParameter("stadium");
            String coach = request.getParameter("coach");

            teamService.updateTeam(id, name, city, country, stadium, coach);
            response.sendRedirect(request.getContextPath() + "/player?id=" + id);
        } catch (Exception ex) {

            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }
}

