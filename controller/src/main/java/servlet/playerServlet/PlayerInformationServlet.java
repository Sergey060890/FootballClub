package servlet.playerServlet;

import footballclub.entity.Player;
import managment.implementation.PlayerServiceImpl;
import managment.interfaces.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/informationPlayer")
public class PlayerInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlayerService playerService = new PlayerServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        try {
            Player player = playerService.findPlayerById(id);
            request.setAttribute("player", player);
            request.getServletContext().getRequestDispatcher("/player-jsp/playerInformation.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}