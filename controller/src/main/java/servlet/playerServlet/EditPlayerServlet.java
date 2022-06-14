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

@WebServlet(EditPlayerServlet.EDIT_PLAYER)
public class EditPlayerServlet extends HttpServlet {

    public static final String EDIT_PLAYER = "/editPlayer";
    public static final String ID = "id";
    public static final String PLAYER = "player";
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String COUNTRY = "country";
    public static final String AGE = "age";
    public static final String POSITION = "position";
    public static final String PLAYER_JSP_EDIT_PLAYER_JSP = "/player-jsp/editPlayer.jsp";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String PLAYER_LINE_UP_ID = "/playerLineUp?id=";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PlayerService playerService = new PlayerServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);

        try {
            Player player = playerService.findPlayerById(id);
            if (player != null) {
                request.setAttribute(PLAYER, player);
                request.setAttribute(NAME, player.getPlayer_name());
                request.setAttribute(SURNAME, player.getPlayer_surname());
                request.setAttribute(COUNTRY, player.getCountry());
                request.setAttribute(AGE, player.getAge());
                request.setAttribute(POSITION, player.getPosition());
                request.getServletContext().getRequestDispatcher(PLAYER_JSP_EDIT_PLAYER_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            PlayerService playerService = new PlayerServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            Player player = playerService.findPlayerById(id);
            String name = request.getParameter(NAME);
            String surname = request.getParameter(SURNAME);
            String city = request.getParameter(COUNTRY);
            Integer age = Integer.valueOf(request.getParameter(AGE));
            String position = request.getParameter(POSITION);
            int idTeam = player.getTeamPlayer().getTeam_id();
            playerService.updatePlayer(id, name, surname, city, age, position);
            response.sendRedirect(request.getContextPath() + PLAYER_LINE_UP_ID + idTeam);
        } catch (Exception ex) {

            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
