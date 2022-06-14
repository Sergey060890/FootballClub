package servlet.gameServlet;

import footballclub.entity.Game;
import managment.implementation.GameServiceImpl;
import managment.interfaces.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(EditGameServlet.EDIT_GAME)
public class EditGameServlet extends HttpServlet {

    public static final String EDIT_GAME = "/editGame";
    public static final String ID = "id";
    public static final String GAME = "game";
    public static final String OPPONENT = "opponent";
    public static final String GAME_JSP_EDIT_GAME_JSP = "/game-jsp/editGame.jsp";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";
    public static final String GAME_ID = "/game?id=";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter(ID));
        request.setAttribute(ID, id);

        try {
            Game game = gameService.findGameById(id);
            if (game != null) {
                request.setAttribute(GAME, game);
                request.setAttribute(OPPONENT, game.getOpponent_name());
                request.getServletContext().getRequestDispatcher(GAME_JSP_EDIT_GAME_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            Game game = gameService.findGameById(id);
            String opponent = request.getParameter(OPPONENT);
            int idTeam = game.getTeamGame().getTeam_id();
            gameService.updateGame(id, opponent);
            response.sendRedirect(request.getContextPath() + GAME_ID + idTeam);
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }

}
