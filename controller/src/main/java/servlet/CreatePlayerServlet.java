package servlet;

import footballclub.entity.Player;
import managment.implementation.PlayerServiceImpl;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.PlayerService;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet("/createPlayer")
    public class CreatePlayerServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
//                            int id = Integer.parseInt(request.getParameter("id"));
            getServletContext().getRequestDispatcher("/createPlayer.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                TeamService teamService = new TeamServiceImpl();
                int id = Integer.parseInt(request.getParameter("id"));
                PlayerService playerService = new PlayerServiceImpl();
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String country = request.getParameter("contrary");
                Integer age1 = Integer.valueOf(request.getParameter("age"));
                String position = request.getParameter("position");

                Set<Player> players = teamService.showAllPlayerTeamInfo(id);
                request.setAttribute("id", id);
                request.setAttribute("players", players);

            Player player = playerService.createPlayer(name,surname,country,age1,position);
            try {
                teamService.addPlayerInTeam(player,teamService.findTeamId(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect(request.getContextPath() + "/playerLineUp?id="+id);

        }
    }


