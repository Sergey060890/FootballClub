package servlet.gameServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/goGame")
public class GoGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
////            GameService gameService = new GameServiceImpl();
////            int id = Integer.parseInt(request.getParameter("id"));
////            request.setAttribute("id", id);
////            String[] players = request.getParameterValues("playersGo");
////            Set<Player> playersGo = gameService.startGamePlayer(id, players);
////            Set<Player> playersNoGo = gameService.noStartGamePlayer(id, players);
////            Game game = gameService.findGameById(id);
////            List<String> info = gameService.showGameAndStats(gameService, game, playersGo, playersNoGo);
////            request.setAttribute("id", id);
////            request.setAttribute("playersGo", playersGo);
////            request.setAttribute("playersNoGo", playersNoGo);
////            request.setAttribute("game", game);
////            request.setAttribute("players", players);
////            request.setAttribute("info", info);
//            request.getServletContext().getRequestDispatcher("/player-jsp/goPlayer.jsp").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
