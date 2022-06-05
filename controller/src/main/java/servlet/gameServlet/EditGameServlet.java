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
import java.time.LocalDate;


@WebServlet("/editGame")
public class EditGameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);

        try {
            Game game = gameService.findGameById(id);
            if (game != null) {
                request.setAttribute("game", game);
                request.setAttribute("date", game.getGame_date());
                request.setAttribute("opponent", game.getOpponent_name());
//                request.setAttribute("result", game.getResult());
//                request.setAttribute("gs", game.getGoal_score());
//                request.setAttribute("gc", game.getGoals_conceded());
//                request.setAttribute("yc", game.getYellow_card_score());
//                request.setAttribute("rc", game.getRed_card_score());
                request.getServletContext().getRequestDispatcher("/game-jsp/editGame.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Game game = gameService.findGameById(id);
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String opponent = request.getParameter("opponent");
            int idTeam = game.getTeamGame().getTeam_id();
            gameService.updateGame(id,date,opponent);
            response.sendRedirect(request.getContextPath() + "/game?id=" + idTeam);
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }

}
