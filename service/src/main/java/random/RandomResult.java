package random;

import footballclub.entity.Player;

import java.sql.SQLException;
import java.util.Random;
import java.util.Set;

import static random.ConstansRandom.*;

public class RandomResult {

    public static final String GK = "GK";
    public static final int INT = 67235;
    public static final int INT1 = 68530;
    public static final int INT2 = 69320;
    public static final int INT3 = 71400;
    public static final int INT4 = 72917;
    public static final int INT5 = 76300;
    public static final int INT6 = 77804;
    public static final int INT7 = 79100;
    public static final int INT8 = 79420;
    public static final int INT9 = 80510;
    public static final int INT10 = 81044;
    public static final String MARK_GEIGER = "Mark Geiger";
    public static final String MARTIN_ATKINSON = "Martin Atkinson";
    public static final String ANTHONY_TAYLOR = "Anthony Taylor";
    public static final String MATEU_LAHOZ = "Mateu Lahoz";
    public static final String DAMIR_SKOMINA = "Damir Skomina";
    public static final String BJORN_KUIPERS = "Bjorn Kuipers";
    public static final String FELIX_BRYCH = "Felix Brych";
    public static final String DANIELE_ORSATO = "Daniele Orsato";

    public int randomGoal() {
        int i = MIN_GOAL + (int) (Math.random() * MAX_GOAL);
        return i;
    }

    public String randomResult(Integer gs, Integer gc) throws SQLException {
        String resultGame;
        if (gs > gc) {
            resultGame = WIN;
        } else if (gs == gc) {
            resultGame = DRAW;
        } else {
            resultGame = LOSE;
        }
        return resultGame;
    }

    public int randomYellowCardScore() {
        int[] myIntYC = new int[]{INT_0, INT_1, INT_1, INT_1,
                INT_2, INT_2, INT_2, INT_2, INT_2, INT_2, INT_3, INT_3};
        Random random = new Random();
        int n = myIntYC[random.nextInt(myIntYC.length)];
        return n;
    }

    public int randomRedCardScore() {
        int[] myIntRC = new int[]{INT_0, INT_0, INT_0, INT_0, INT_0,
                INT_0, INT_0, INT_0, INT_1, INT_1, INT_1, INT_1, INT_2};
        Random random = new Random();
        int n = myIntRC[random.nextInt(myIntRC.length)];
        return n;
    }

    public int timeRandomGoal() {
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomYC() {
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomRC() {
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomSubs() {
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int countSubs() {
        int[] myIntSubs = new int[]{INT_1, INT_1, INT_2, INT_2, INT_2, INT_2, INT_3, INT_3,
                INT_3, INT_3, INT_3, INT_3, INT_3};
        Random random = new Random();
        int n = myIntSubs[random.nextInt(myIntSubs.length)];
        return n;
    }


    public Player create(Set<Player> players) {
        Player player;
        Random rnd = new Random();
        int i = rnd.nextInt(players.size());
        player = (Player) players.toArray()[i];
        return player;
    }

    public Player createNoGk(Set<Player> players) {
        Player player;
        Random rnd = new Random();
        players.removeIf(p -> p.getPosition().equals(GK));
        int i = rnd.nextInt(players.size());
        player = (Player) players.toArray()[i];
        return player;
    }

    public Player createGoalConcPlayer(Set<Player> players) {
        Player player = null;
        for (Player player1 : players
        ) {
            if (player1.getPosition().equals(GK)) {
                player = player1;
            }
        }
        return player;
    }

    public int attendance() {
        int[] myIntAtt = new int[]{INT, INT1, INT2, INT3, INT4, INT5, INT6, INT7, INT8, INT9,
                INT10};
        Random random = new Random();
        int n = myIntAtt[random.nextInt(myIntAtt.length)];
        return n;
    }


    public String referee() {
        String[] myIntRef = new String[]{MARK_GEIGER, MARTIN_ATKINSON, ANTHONY_TAYLOR,
                MATEU_LAHOZ, DAMIR_SKOMINA, BJORN_KUIPERS, FELIX_BRYCH, DANIELE_ORSATO};
        Random random = new Random();
        String n = myIntRef[random.nextInt(myIntRef.length)];
        return n;
    }
}
