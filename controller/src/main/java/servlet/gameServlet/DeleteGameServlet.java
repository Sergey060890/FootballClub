package servlet.gameServlet;

import footballclub.entity.Result;
import managment.implementation.ResultServiceImpl;
import managment.interfaces.ResultService;

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
//            GameService gameService = new GameServiceImpl();
            ResultService resultService = new ResultServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
//            Game game = gameService.findGameById(id);
            Result result = resultService.findResultById(id);
            int idTeam = result.getTeamGame().getTeam_id();
            resultService.deleteResult(id);
            response.sendRedirect(request.getContextPath() + GAME_ID + idTeam);
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
