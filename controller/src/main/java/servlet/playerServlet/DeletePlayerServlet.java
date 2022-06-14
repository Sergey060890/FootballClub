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

@WebServlet(DeletePlayerServlet.DELETE_PLAYER)
public class DeletePlayerServlet extends HttpServlet {

    public static final String DELETE_PLAYER = "/deletePlayer";
    public static final String ID = "id";
    public static final String PLAYER_LINE_UP_ID = "/playerLineUp?id=";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PlayerService playerService = new PlayerServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            Player player = playerService.findPlayerById(id);
            int idTeam = player.getTeamPlayer().getTeam_id();

            playerService.deletePlayer(id);
            response.sendRedirect(request.getContextPath() + PLAYER_LINE_UP_ID + idTeam);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}

