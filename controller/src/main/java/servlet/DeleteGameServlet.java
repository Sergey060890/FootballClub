package servlet;

import footballclub.entity.Game;
import managment.implementation.GameServiceImpl;
import managment.interfaces.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteGame")
public class DeleteGameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findGameById(id);
            int idTeam = game.getTeamGame().getTeam_id();

            gameService.deleteGame(id);
            response.sendRedirect(request.getContextPath() + "/game?id=" + idTeam);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
