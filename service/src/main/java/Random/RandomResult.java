package Random;

import java.sql.SQLException;
import java.util.Random;

public class RandomResult {

    public static final int MIN_GOAL = 0;
    public static final int MAX_GOAL = 6;
    public static final String WIN = "WIN";
    public static final String DRAW = "DRAW";
    public static final String LOSE = "LOSE";
    public static final int INT_0 = 0;
    public static final int INT_1 = 1;
    public static final int INT_2 = 2;
    public static final int INT_3 = 3;
    public static final int MIN_TIME = 0;
    public static final int MAX_TIME= 94;


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
        int[] myIntYC = new int[]{INT_0, INT_0, INT_1, INT_1, INT_1,
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

    public int timeRandomGoal(){
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomYC(){
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomRC(){
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public int timeRandomSubs(){
        int i = MIN_TIME + (int) (Math.random() * MAX_TIME);
        return i;
    }

    public static void main(String[] args) {
        RandomResult random = new RandomResult();
//        System.out.println(" GOOOOAAAL min-" +random.timeRandomGoal());
//        System.out.println(" Yellow card min-" +random.timeRandomYC());
//        System.out.println("Red card min"  + random.timeRandomRC());
//        System.out.println("Subs" + random.timeRandomSubs());
    }


}
