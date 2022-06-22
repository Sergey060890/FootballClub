package servlet.teamServlet;

import dto.TeamDTO;
import managment.implementation.TeamServiceImpl;
import managment.interfaces.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(SelectionTeamServlet.SELECTION)
public class SelectionTeamServlet extends HttpServlet {

    public static final String SELECTION = "/selection";
    public static final String ID = "id";
    public static final String TEAM_JSP_MY_TEAM_JSP = "/team-jsp/myTeam.jsp";
    public static final String OTHER_JSP_NOTFOUND_JSP = "/other-jsp/notfound.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            TeamService teamService = new TeamServiceImpl();
            int id = Integer.parseInt(request.getParameter(ID));
            request.setAttribute(ID, id);
            TeamDTO teamDTO = teamService.findTeamById(id);
//            Set<Player> players = teamService.showAllPlayerTeamInfo(id);
//            Set<Game> games = teamDTO.getGames();
            if (teamDTO != null) {
                request.getServletContext().getRequestDispatcher(TEAM_JSP_MY_TEAM_JSP).forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
            }
        } catch (Exception ex) {
            request.getServletContext().getRequestDispatcher(OTHER_JSP_NOTFOUND_JSP).forward(request, response);
        }
    }
}
