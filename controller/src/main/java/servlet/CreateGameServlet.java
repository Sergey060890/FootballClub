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
import java.time.LocalDate;

@WebServlet("/createGame")
public class CreateGameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/createGame.jsp").forward(request, response);
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
            gameService.updateGame(id, date, opponent);
            response.sendRedirect(request.getContextPath() + "/game?id=" + idTeam);
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}