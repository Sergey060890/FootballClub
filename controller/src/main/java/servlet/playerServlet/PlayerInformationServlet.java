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

@WebServlet(PlayerInformationServlet.INFORMATION_PLAYER)
public class PlayerInformationServlet extends HttpServlet {

    public static final String INFORMATION_PLAYER = "/informationPlayer";
    public static final String ID = "id";
    public static final String PLAYER = "player";
    public static final String PLAYER_JSP_PLAYER_INFORMATION_JSP = "/player-jsp/playerInformation.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlayerService playerService = new PlayerServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);
        try {
            Player player = playerService.findPlayerById(id);
            request.setAttribute(PLAYER, player);
            request.getServletContext().getRequestDispatcher(PLAYER_JSP_PLAYER_INFORMATION_JSP).forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
