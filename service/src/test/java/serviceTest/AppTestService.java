package serviceTest;

import footballclub.util.HibernateUtil;
import org.junit.AfterClass;

public class AppTestService {
    /**
     * Hinernate Factory close test
     */
    @AfterClass
    public static void clean() {
        HibernateUtil.close();
    }
}
