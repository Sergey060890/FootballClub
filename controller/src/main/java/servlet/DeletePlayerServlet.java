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

@WebServlet("/deletePlayer")
public class DeletePlayerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PlayerService playerService = new PlayerServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Player player = playerService.findPlayerById(id);
            int idTeam = player.getTeamPlayer().getTeam_id();

            playerService.deletePlayer(id);
            response.sendRedirect(request.getContextPath() + "/playerLineUp?id=" + idTeam);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

