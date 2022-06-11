package managment.implementation;

import DTO.GameDTO;
import DTO.mapper.GameMapper;
import Random.RandomResult;
import footballclub.dao.implementations.EnityDaoImplGame;
import footballclub.dao.implementations.EnityDaoImplGoalConceded;
import footballclub.dao.implementations.EnityDaoImplGoalScore;
import footballclub.dao.implementations.EnityDaoImplRedCard;
import footballclub.dao.implementations.EnityDaoImplSubstitution;
import footballclub.dao.implementations.EnityDaoImplYellowCard;
import footballclub.entity.Game;
import footballclub.entity.GoalConceded;
import footballclub.entity.GoalScore;
import footballclub.entity.Player;
import footballclub.entity.RedCard;
import footballclub.entity.Substitution;
import footballclub.entity.Team;
import footballclub.entity.YellowCard;
import managment.interfaces.GameService;
import managment.interfaces.TeamService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService {
    EnityDaoImplGame enityDaoImplGame =
            new EnityDaoImplGame();
    EnityDaoImplGoalScore enityDaoImplGoalScore =
            new EnityDaoImplGoalScore();
    EnityDaoImplGoalConceded enityDaoImplGoalConceded =
            new EnityDaoImplGoalConceded();
    EnityDaoImplYellowCard enityDaoImplYellowCard =
            new EnityDaoImplYellowCard();
    EnityDaoImplRedCard enityDaoImplRedCard =
            new EnityDaoImplRedCard();
    EnityDaoImplSubstitution enityDaoImplSubstitution =
            new EnityDaoImplSubstitution();
    RandomResult random = new RandomResult();
    TeamService teamService = new TeamServiceImpl();



    public static List<Game> games = new ArrayList<>();
    public static List<GoalScore> goalScores = new ArrayList<>();
    public static List<YellowCard> yellowCards = new ArrayList<>();
    public static List<RedCard> redCards = new ArrayList<>();

    @Override
    public Game createGame(Team team,
                           String opponentTeam) throws SQLException {
        int goalS = random.randomGoal();
        int goalC = random.randomGoal();
        Game game = Game.builder()
                .teamGame(team)
                .opponent_name(opponentTeam)
                .goal_score(goalS)
                .goals_conceded(goalC)
                .result(random.randomResult(goalS,goalC))
                .yellow_card_score(random.randomYellowCardScore())
                .red_card_score(random.randomRedCardScore())
                .build();
        enityDaoImplGame.create(game);
        games.add(game);
        return game;
    }

    @Override
    public Game createGameNoPlayers(Team team,
                           String opponentTeam) {
        Game game = Game.builder()
                .teamGame(team)
                .opponent_name(opponentTeam)
                .build();
        enityDaoImplGame.create(game);
        return game;
    }

    @Override
    public Game addPlayersInGame(Integer idGame, Set<Player> players) throws SQLException {
        Game game = enityDaoImplGame.findOne(idGame);
        game.setPlayers(players);
        enityDaoImplGame.update(game);
        return game;
    }

    @Override
    public List<GameDTO> findAll() {
        return enityDaoImplGame.findAll()
                .stream()
                .map(GameMapper::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, String> showAllOpponentTeamInfo(Set<Game> gameSet) {
        Map<Integer, String> map = new HashMap<>();
        for (Game g : gameSet
        ) {
            map.put(g.getGame_id(), g.getOpponent_name());
        }
        return map;
    }

    @Override
    public Set<Game> showAllGameTeamInfo(Integer id) {
        Set<Game> players = new HashSet<>();
        for (Game game : enityDaoImplGame.findAll()
        ) {
            if (game.getTeamGame().getTeam_id() == id) {
                players.add(game);
            }
        }
        return players;
    }

    @Override
    public Set<Player> showAllGamePlayerInfo(Integer id) throws SQLException {
        Game game = enityDaoImplGame.findOne(id);
        Set<Player> players = game.getPlayers();
        return players;
    }

    @Override
    public Set<Player> startGamePlayer(Integer id, String[] players) throws SQLException {
        Set<Player> playerSet = teamService.showAllPlayerTeamInfo(id);
        Set<String> mySet = new HashSet<>(Arrays.asList(players));
        Set<Player> playersGo = new HashSet<>();
        for (Player player : playerSet
        ) {
            for (String str : mySet
            ) {
                if (player.getPlayer_surname().equals(str)) {
                    playersGo.add(player);
                }
            }
        }
        return playersGo;
    }

    @Override
    public GoalScore createGoalScore(Game game, Player player, Integer time) {
        GoalScore goal = GoalScore.builder()
                .game(game)
                .player(player)
                .goal_time(random.timeRandomGoal())
                .build();
        enityDaoImplGoalScore.create(goal);
        return goal;
    }

    @Override
    public GoalConceded createGoalConceded(Game game, Player player, Integer time) {
        GoalConceded goalConc = GoalConceded.builder()
                .game(game)
                .player(player)
                .conceded_time(random.timeRandomGoal())
                .build();
        enityDaoImplGoalConceded.create(goalConc);
        return goalConc;
    }

    @Override
    public YellowCard createYellowCard(Game game, Player player, Integer time) {
        YellowCard yc = YellowCard.builder()
                .game(game)
                .player(player)
                .card_time(time)
                .build();
        enityDaoImplYellowCard.create(yc);
        return yc;
    }

    @Override
    public RedCard createRedCard(Game game, Player player, Integer time) {
        RedCard rc = RedCard.builder()
                .game(game)
                .player(player)
                .card_time(time)
                .build();
        enityDaoImplRedCard.create(rc);
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
        enityDaoImplSubstitution.create(subs);
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
    public List<String> showGameAndStats(Game game, Set<GoalScore> goal, Set<GoalConceded> goalConc, Set<YellowCard> yc, Set<RedCard> rc, Set<Substitution> subs) {
        return null;
    }

//    @Override
//    public List<String> showGameAndStats(Game game, Set<GoalScore> goal,
//                                         Set<GoalConceded> goalConc,
//                                         Set<YellowCard> yc,
//                                         Set<RedCard> rc,
//                                         Set<Substitution> subs) {
//        System.out.println("Data game: " + game.getGame_date());
//        System.out.println("----------------------------");
//        System.out.println(game.getTeamGame().getTeam_name() +
//                " VS " + game.getOpponent_name());
//        System.out.println("----------------------------");
//        System.out.println("GAME PROGRESS:");
//        System.out.println("----------------------------");
//
//        int countGoal = 0;
//        int countConc = 0;
//
//        Map<Integer, String> strGoal = new HashMap<>();
//        for (GoalScore g : goal
//        ) {
//            System.out.println("GOOOOOOOOOOOOL!!! :-)");
//            System.out.println(g.getPlayer().getPlayer_surname()
//                    + " " + g.getGoal_time() + "'");
//            strGoal.put(g.getGoal_time(), g.getPlayer().getPlayer_surname());
//            countGoal++;
//            System.out.println(countGoal + ":" + countConc);
//            System.out.println("----------------------------");
//            goalScores.add(g);
//        }
//
//        for (GoalConceded gc : goalConc
//        ) {
//            System.out.println(gc.getConceded_time() + "'" + " Goal missed!!! :-(");
//            countConc++;
//            System.out.println(countGoal + ":" + countConc);
//            System.out.println("----------------------------");
//        }
//
//        for (YellowCard ycrd : yc
//        ) {
//            System.out.println("Yellow card!");
//            System.out.println(ycrd.getPlayer().getPlayer_surname()
//                    + " " + ycrd.getCard_time() + "'");
//            System.out.println("----------------------------");
//            yellowCards.add(ycrd);
//        }
//
//        for (RedCard rcrd : rc
//        ) {
//            System.out.println("Red card!");
//            System.out.println(rcrd.getPlayer().getPlayer_surname()
//                    + " " + rcrd.getCard_time() + "'");
//            System.out.println("----------------------------");
//            redCards.add(rcrd);
//        }
//
//        for (Substitution subst : subs
//        ) {
//            System.out.println("SUBSTITUTION:");
//            System.out.println(subst.getSubs_time() + "'");
//            System.out.println("Entered the game: " + subst.getPlayerIn().getPlayer_surname());
//            System.out.println("Left the game: " + subst.getPlayerOut().getPlayer_surname());
//            System.out.println("----------------------------");
//        }
//        System.out.println("End of the game");
//        System.out.println("----------------------------");
//        System.out.println("RESULT: " + game.getGoal_score() + ":" + game.getGoals_conceded());
//
//        Iterator<Map.Entry<Integer, String>> entries = strGoal.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<Integer, String> entry = entries.next();
//            System.out.println(entry.getKey() + "' " + entry.getValue());
//        }
//        System.out.println("Yellow card:" + game.getYellow_card_score());
//        System.out.println("Red card:" + game.getRed_card_score());
//        System.out.println("-----------------------");
//        String str = game.toString();
//        String str1 = goal.toString();
//        String str2 = goalConc.toString();
//        String str3 = yc.toString();
//        String str4 = rc.toString();
//        String str5 = subs.toString();
//        List<String> list = new ArrayList<>();
//        list.add(str);
//        list.add(str1);
//        list.add(str2);
//        list.add(str3);
//        list.add(str4);
//        list.add(str4);
//        list.add(str5);
//        return list;
//    }

    @Override
    public void deleteGame(Integer id) throws SQLException {
        enityDaoImplGame.deleteById(id);
    }

    @Override
    public void updateGame(Integer id,
                           String opponentTeam) throws SQLException {
        Game game = enityDaoImplGame.findOne(id);
        game.setOpponent_name(opponentTeam);
        enityDaoImplGame.update(game);
    }

    @Override
    public Game findGameById(Integer id) throws SQLException  {
        return enityDaoImplGame.findOne(id);
    }
}
