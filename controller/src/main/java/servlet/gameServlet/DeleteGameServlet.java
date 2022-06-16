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

@WebServlet(DeleteGameServlet.DELETE_GAME)
public class DeleteGameServlet extends HttpServlet {

    public static final String DELETE_GAME = "/deleteGame";
    public static final String ID = "id";
    public static final String GAME_ID = "/game?id=";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            Game game = gameService.findGameById(id);
            int idTeam = game.getTeamGame().getTeam_id();
            gameService.deleteGame(id);
            response.sendRedirect(request.getContextPath() + GAME_ID + idTeam);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
