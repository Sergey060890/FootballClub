package servlet;

import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create")
public class CreateTeamServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createTeam.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            TeamService teamService = new TeamServiceImpl();

            String name = request.getParameter("name");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String stadium = request.getParameter("stadium");
            String coach = request.getParameter("coach");

            teamService.createTeam(name, city, country, stadium, coach);
            response.sendRedirect(request.getContextPath() + "/TeamServlet");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/createTeam.jsp").forward(request, response);
        }
    }
}
