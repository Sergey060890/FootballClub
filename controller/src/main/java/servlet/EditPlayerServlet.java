package servlet;

import footballclub.entity.Player;
import managment.implementation.PlayerServiceImpl;
import managment.interfaces.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editPlayer")
public class EditPlayerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService playerService = new PlayerServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);

        try {
            Player player = playerService.findPlayerById(id);
            if (player != null) {
                request.setAttribute("player", player);
                request.setAttribute("name", player.getPlayer_name());
                request.setAttribute("surname", player.getPlayer_surname());
                request.setAttribute("country", player.getCountry());
                request.setAttribute("age", player.getAge());
                request.setAttribute("position", player.getPosition());
                request.getServletContext().getRequestDispatcher("/editPlayer.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PlayerService playerService = new PlayerServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Player player = playerService.findPlayerById(id);
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String city = request.getParameter("country");
            Integer age = Integer.valueOf(request.getParameter("age"));
            String position = request.getParameter("position");
            int idTeam = player.getTeamPlayer().getTeam_id();
            playerService.updatePlayer(id, name, surname, city, age, position);
            response.sendRedirect(request.getContextPath() + "/playerLineUp?id=" + idTeam);
        } catch (Exception ex) {

            request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
