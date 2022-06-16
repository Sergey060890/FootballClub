package Random;

import footballclub.entity.Player;

import java.sql.SQLException;
import java.util.Random;
import java.util.Set;

import static Random.ConstansRandom.*;

public class RandomResult {

    public int randomGoal() {
        int i = MIN_GOAL + (int) (Math.random() * MAX_GOAL);
        return i;
    }


    public String randomResult(Integer gs, Integer gc) throws SQLException {
        String resultGame;
        int i = gs;
        int b = gc;
        if (i > b) {
            resultGame = WIN;
        } else if (i == b) {
            resultGame = DRAW;
        } else {
            resultGame = LOSE;
        }
        System.out.println(resultGame);
        return resultGame;
    }

    public int randomYellowCardScore() {
        int[] myIntYC = new int[]{INT_0, INT_1, INT_1, INT_1,
                INT_2, INT_2, INT_2, INT_2, INT_2, INT_2, INT_3, INT_3};
        Random random = new Random();
        int n = myIntYC[random.nextInt(myIntYC.length)];
        System.out.println(n);
        return n;
    }

    public int randomRedCardScore() {
        int[] myIntRC = new int[]{INT_0, INT_0, INT_0, INT_0, INT_0,
                INT_0, INT_0, INT_0, INT_1, INT_1, INT_1, INT_1, INT_2};
        Random random = new Random();
        int n = myIntRC[random.nextInt(myIntRC.length)];
        System.out.println(n);
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
        int[] myIntRC = new int[]{INT_1, INT_1, INT_2, INT_2, INT_2, INT_2, INT_3, INT_3,
                INT_3, INT_3, INT_3, INT_3, INT_3};
        Random random = new Random();
        int n = myIntRC[random.nextInt(myIntRC.length)];
        System.out.println(n);
        return n;
    }


    public Player create(Set<Player> players) {
        Player player;
        Random rnd = new Random();
        int i = rnd.nextInt(players.size());
        player = (Player) players.toArray()[i];
        return player;
    }

}
