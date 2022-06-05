package servlet.gameServlet;

import footballclub.entity.Team;
import managment.implementation.GameServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.GameService;
import managment.interfaces.TeamService;

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
        getServletContext().getRequestDispatcher("/game-jsp/createGame.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            TeamService teamService = new TeamServiceImpl();
            GameService gameService = new GameServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            Team team =   teamService.findTeamId(id);
            LocalDate date = LocalDate.parse(request.getParameter("date"));
            String opponent = request.getParameter("opponent");
            gameService.createGame(date,team,opponent);
            response.sendRedirect(request.getContextPath() + "/game?id=" + id);
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher("/other-jsp/notfound.jsp").forward(request, response);
        }
    }

}