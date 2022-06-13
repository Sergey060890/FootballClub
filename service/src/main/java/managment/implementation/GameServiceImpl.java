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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService {
    public static final String RED_CARD = " Red card! ";
    public static final String YELLOW_CARD = " Yellow card! ";
    public static final String STRING = ":";
    public static final String GOAL_MISSED = " Goal missed! ";
    public static final String GOOOOAAAAL = "' GOOOOAAAAL! ";
    public static final String STRING1 = " ";

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
                .result(random.randomResult(goalS, goalC))
                .yellow_card_score(random.randomYellowCardScore())
                .red_card_score(random.randomRedCardScore())
                .build();
        enityDaoImplGame.create(game);
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
    public Map<Integer, String> opponentRemoveTeam(GameService service, Game game, Set<Game> gameSet) {
        Map<Integer, String> games =
                service.showAllOpponentTeamInfo(gameSet);
        for (Game g : gameSet
        ) {
            if (g.getOpponent_name() == game.getOpponent_name()) {
                games.remove(g.getGame_id());
            }
        }
        return games;
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
    public Set<Player> noStartGamePlayer(Integer id, String[] players) throws SQLException {
        Set<Player> playerSet = teamService.showAllPlayerTeamInfo(id);
        Set<String> mySet = new HashSet<>(Arrays.asList(players));
        Set<Player> playersNoGo = new HashSet<>();
        for (Player player : playerSet
        ) {
            for (String str : mySet
            ) {
                if (player.getPlayer_surname().equals(str)) {
                    continue;
                } else {
                    playersNoGo.add(player);
                }
            }
        }
        return playersNoGo;
    }

    @Override
    public GoalScore createGoalScore(Game game, Set<Player> players) {
        GoalScore goal = GoalScore.builder()
                .game(game)
                .player(random.create(players))
                .goal_time(random.timeRandomGoal())
                .build();
        enityDaoImplGoalScore.create(goal);
        return goal;
    }

    @Override
    public GoalConceded createGoalConceded(Game game, Set<Player> players) {
        GoalConceded goalConc = GoalConceded.builder()
                .game(game)
                .player(random.create(players))
                .conceded_time(random.timeRandomGoal())
                .build();
        enityDaoImplGoalConceded.create(goalConc);
        return goalConc;
    }

    @Override
    public YellowCard createYellowCard(Game game, Set<Player> players) {
        YellowCard yc = YellowCard.builder()
                .game(game)
                .player(random.create(players))
                .card_time(random.timeRandomYC())
                .build();
        enityDaoImplYellowCard.create(yc);
        return yc;
    }

    @Override
    public RedCard createRedCard(Game game, Set<Player> players) {
        RedCard rc = RedCard.builder()
                .game(game)
                .player(random.create(players))
                .card_time(random.timeRandomRC())
                .build();
        enityDaoImplRedCard.create(rc);
        return rc;
    }

    @Override
    public Substitution createSubs(Game game, Set<Player> playersIn, Set<Player> playersOut) {
        Substitution subs = Substitution.builder()
                .game(game)
                .playerIn(random.create(playersIn))
                .playerOut(random.create(playersOut))
                .subs_time(random.timeRandomSubs())
                .build();
        enityDaoImplSubstitution.create(subs);
        return subs;
    }


    @Override
    public Set<Game> showAllPlayerGame(Game game) {
        Set<Game> games = new HashSet<>();
        games.add(game);
        System.out.println(game.getPlayers());
        return games;
    }

    @Override
    public List<String> showGameAndStats(GameService service, Game game, Set<Player> start, Set<Player> noStart) {
        if (game.getGoal_score() != 0) {
            for (int i = 1; i <= game.getGoal_score(); i++) {
                service.createGoalScore(game, start);
            }
        }

        if (game.getGoals_conceded() != 0) {
            for (int i = 1; i <= game.getGoals_conceded(); i++) {

                service.createGoalConceded(game, start);
            }
        }

        if (game.getYellow_card_score() != 0) {
            for (int i = 1; i <= game.getYellow_card_score(); i++) {
                service.createYellowCard(game, start);
            }
        }

        if (game.getRed_card_score() != 0) {
            for (int i = 1; i <= game.getRed_card_score(); i++) {
                service.createYellowCard(game, start);
            }
        }


        for (int i = 1; i <= random.countSubs(); i++) {
            service.createSubs(game, start, noStart);
        }

        List<GoalScore> goal = enityDaoImplGoalScore.findAll();
        List<GoalConceded> goalConc = enityDaoImplGoalConceded.findAll();
        List<YellowCard> yellow = enityDaoImplYellowCard.findAll();
        List<RedCard> red = enityDaoImplRedCard.findAll();
        List<Substitution> subs = enityDaoImplSubstitution.findAll();

        List<GoalScore> goalAdd = new ArrayList<>();
        List<GoalConceded> goalConcAdd = new ArrayList<>();
        List<YellowCard> yellowAdd = new ArrayList<>();
        List<RedCard> redAdd = new ArrayList<>();
        List<Substitution> subsAdd = new ArrayList<>();


        List<Integer> timeMoment = new ArrayList<>();
        for (GoalScore goals : goal
        ) {
            if (goals.getGame().getGame_id() == game.getGame_id()) {
                timeMoment.add(goals.getGoal_time());
                goalAdd.add(goals);
            }
        }

        for (GoalConceded goalConceded : goalConc
        ) {
            if (goalConceded.getGame().getGame_id() == game.getGame_id()) {
                timeMoment.add(goalConceded.getConceded_time());
                goalConcAdd.add(goalConceded);
            }
        }

        for (YellowCard yc : yellow
        ) {
            if (yc.getGame().getGame_id() == game.getGame_id()) {
                timeMoment.add(yc.getCard_time());
                yellowAdd.add(yc);
            }
        }

        for (RedCard rc : red
        ) {
            if (rc.getGame().getGame_id() == game.getGame_id()) {
                timeMoment.add(rc.getCard_time());
                redAdd.add(rc);
            }
        }

        for (Substitution subst : subs
        ) {
            if (subst.getGame().getGame_id() == game.getGame_id()) {
                timeMoment.add(subst.getSubs_time());
                subsAdd.add(subst);
            }
        }
        Collections.sort(timeMoment);

        int countGoal = 0;
        int countConc = 0;

        List<String> listInfo = new ArrayList<>();

        for (int counter : timeMoment) {
            for (GoalScore goalScore : goalAdd
            ) {
                if (goalScore.getGoal_time() == counter) {
                    countGoal++;
                    listInfo.add(goalScore.getGoal_time() + GOOOOAAAAL
                            + goalScore.getPlayer().getPlayer_surname() + STRING1 +
                            countGoal + STRING + countConc);
                }
            }

            for (GoalConceded gc : goalConcAdd
            ) {
                if (gc.getConceded_time() == counter) {
                    countConc++;
                    listInfo.add(gc.getConceded_time() + GOAL_MISSED
                            + countGoal + STRING + countConc);
                }
            }

            for (YellowCard yellowCard : yellowAdd
            ) {
                if (yellowCard.getCard_time() == counter) {
                    listInfo.add(yellowCard.getCard_time() + YELLOW_CARD
                            + yellowCard.getPlayer().getPlayer_surname());
                }
            }

            for (RedCard redCard : redAdd
            ) {
                if (redCard.getCard_time() == counter) {
                    listInfo.add(redCard.getCard_time() + RED_CARD
                            + redCard.getPlayer().getPlayer_surname());
                    start.remove(redCard.getPlayer());
                }
            }

//            for (Substitution substitution : subsAdd
//            ) {
//                if (substitution.getSubs_time() == counter) {
//                    listInfo.add(substitution.getSubs_time() + " Substitution! Out: "
//                            + substitution.getPlayerIn().getPlayer_surname() + " In:" + substitution.getPlayerOut().getPlayer_surname());
//                    start.remove(substitution.getPlayerOut());
//                    start.add(substitution.getPlayerIn());
//                }
//            }
        }
        return listInfo;
    }


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
    public Game findGameById(Integer id) throws SQLException {
        return enityDaoImplGame.findOne(id);
    }
}
