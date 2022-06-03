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
import java.util.Set;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService gameService = new GameServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Set<Game> games = gameService.showAllGameTeamInfo(id);
        request.setAttribute("id", id);
        request.setAttribute("games", games);
        request.getServletContext().getRequestDispatcher("/game.jsp").forward(request, response);
    }
}