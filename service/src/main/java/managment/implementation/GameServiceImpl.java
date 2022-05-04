package managment.implementation;

import footballclub.dao.EnityDaoImplGame;
import footballclub.dao.EnityDaoImplGoalConceded;
import footballclub.dao.EnityDaoImplGoalScore;
import footballclub.dao.EnityDaoImplRedCard;
import footballclub.dao.EnityDaoImplSubstitution;
import footballclub.dao.EnityDaoImplYellowCard;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;
import managment.interfaces.GameService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static managment.ConstansManager.*;

public class GameServiceImpl implements GameService {
    EnityDaoImplGame enityDaoImplGame =
            new EnityDaoImplGame(Game.class);
    EnityDaoImplGoalScore enityDaoImplGoalScore =
            new EnityDaoImplGoalScore(GoalScore.class);
    EnityDaoImplGoalConceded enityDaoImplGoalConceded =
            new EnityDaoImplGoalConceded(GoalConceded.class);
    EnityDaoImplYellowCard enityDaoImplYellowCard =
            new EnityDaoImplYellowCard(YellowCard.class);
    EnityDaoImplRedCard enityDaoImplRedCard =
            new EnityDaoImplRedCard(RedCard.class);
    EnityDaoImplSubstitution enityDaoImplSubstitution =
            new EnityDaoImplSubstitution(Substitution.class);

    public static List<Game> games = new ArrayList<>();
    public static List<GoalScore> goalScores = new ArrayList<>();
    public static List<YellowCard> yellowCards = new ArrayList<>();
    public static List<RedCard> redCards = new ArrayList<>();


    public GameServiceImpl(EnityDaoImplGame enityDaoImplGame) {
        this.enityDaoImplGame = enityDaoImplGame;
    }

    @Override
    public Game createGame(LocalDate date, Team team,
                           Team opponentTeam, Set<Player> lineUpTeam) {
        Set<Player> players1 = new HashSet<>();
        for (Player p : lineUpTeam
        ) {
            if (p.getTeam() == team) {
                players1.add(p);
            }
        }
        Game game = Game.builder()
                .team(team)
                .game_date(date)
                .players(players1)
                .opponent_name(opponentTeam.getTeam_name())
                .result(RESULT_GAME_WIN)
                .goal_score(GOAL_SCORE)
                .goals_conceded(GOALS_CONCEDED)
                .yellow_card_score(YELLOW_CARD_SCORE)
                .red_card_score(RED_CARD_SCORE)
                .build();
        enityDaoImplGame.insert(game);
        games.add(game);
        return game;
    }

    @Override
    public GoalScore createGoalScore(Game game, Player player, Integer time) {
        GoalScore goal = GoalScore.builder()
                .game(game)
                .player(player)
                .goal_time(time)
                .build();
        enityDaoImplGoalScore.insert(goal);
        return goal;
    }

    @Override
    public GoalConceded createGoalConceded(Game game, Player player, Integer time) {
        GoalConceded goalConc = GoalConceded.builder()
                .game(game)
                .player(player)
                .conceded_time(time)
                .build();
        enityDaoImplGoalConceded.insert(goalConc);
        return goalConc;
    }

    @Override
    public YellowCard createYellowCard(Game game, Player player, Integer time) {
        YellowCard yc = YellowCard.builder()
                .game(game)
                .player(player)
                .card_time(time)
                .build();
        enityDaoImplYellowCard.insert(yc);
        return yc;
    }

    @Override
    public RedCard createRedCard(Game game, Player player, Integer time) {
        RedCard rc = RedCard.builder()
                .game(game)
                .player(player)
                .card_time(time)
                .build();
        enityDaoImplRedCard.insert(rc);
        return rc;
    }

    @Override
    public Substitution createSubs(Game game, Player playerIn, Player playerOut, Integer time) {
        Substitution subs = Substitution.builder()
                .game(game)
                .playerIn(playerIn)
                .playerOut(playerOut)
                .subs_time(time)
                .build();
        enityDaoImplSubstitution.insert(subs);
        return subs;
    }


    @Override
    public Set<Game> showAllPlayerGame(Game game) {
        Set<Game> games = new HashSet<>();
        games.add(game);
        System.out.println("Players who took part in the game: ");
        System.out.println(game.getPlayers());
        return games;
    }

    @Override
    public List<String> showGameAndStats(Game game, Set<GoalScore> goal,
                                         Set<GoalConceded> goalConc,
                                         Set<YellowCard> yc,
                                         Set<RedCard> rc,
                                         Set<Substitution> subs) {
        System.out.println("Data game: " + game.getGame_date());
        System.out.println("----------------------------");
        System.out.println(game.getTeam().getTeam_name() +
                " VS " + game.getOpponent_name());
        System.out.println("----------------------------");
        System.out.println("GAME PROGRESS:");
        System.out.println("----------------------------");

        int countGoal = 0;
        int countConc = 0;

        Map<Integer, String> strGoal = new HashMap<>();
        for (GoalScore g : goal
        ) {
            System.out.println("GOOOOOOOOOOOOL!!! :-)");
            System.out.println(g.getPlayer().getPlayer_surname()
                    + " " + g.getGoal_time() + "'");
            strGoal.put(g.getGoal_time(), g.getPlayer().getPlayer_surname());
            countGoal++;
            System.out.println(countGoal + ":" + countConc);
            System.out.println("----------------------------");
            goalScores.add(g);
        }

        for (GoalConceded gc : goalConc
        ) {
            System.out.println(gc.getConceded_time() + "'" + " Goal missed!!! :-(");
            countConc++;
            System.out.println(countGoal + ":" + countConc);
            System.out.println("----------------------------");
        }

        for (YellowCard ycrd : yc
        ) {
            System.out.println("Yellow card!");
            System.out.println(ycrd.getPlayer().getPlayer_surname()
                    + " " + ycrd.getCard_time() + "'");
            System.out.println("----------------------------");
            yellowCards.add(ycrd);
        }

        for (RedCard rcrd : rc
        ) {
            System.out.println("Red card!");
            System.out.println(rcrd.getPlayer().getPlayer_surname()
                    + " " + rcrd.getCard_time() + "'");
            System.out.println("----------------------------");
            redCards.add(rcrd);
        }

        for (Substitution subst : subs
        ) {
            System.out.println("SUBSTITUTION:");
            System.out.println(subst.getSubs_time() + "'");
            System.out.println("Entered the game: " + subst.getPlayerIn().getPlayer_surname());
            System.out.println("Left the game: " + subst.getPlayerOut().getPlayer_surname());
            System.out.println("----------------------------");
        }
        System.out.println("End of the game");
        System.out.println("----------------------------");
        System.out.println("RESULT: " + game.getGoal_score() + ":" + game.getGoals_conceded());

        Iterator<Map.Entry<Integer, String>> entries = strGoal.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
            System.out.println(entry.getKey() + "' " + entry.getValue());
        }
        System.out.println("Yellow card:" + game.getYellow_card_score());
        System.out.println("Red card:" + game.getRed_card_score());
        System.out.println("-----------------------");
        String str = game.toString();
        String str1 = goal.toString();
        String str2 = goalConc.toString();
        String str3 = yc.toString();
        String str4 = rc.toString();
        String str5 = subs.toString();
        List<String> list = new ArrayList<>();
        list.add(str);
        list.add(str1);
        list.add(str2);
        list.add(str3);
        list.add(str4);
        list.add(str4);
        list.add(str5);
        return list;
    }
}
