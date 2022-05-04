package footballclub.entityTest;

import footballclub.util.HibernateUtil;
import org.junit.AfterClass;

public class AppTest {
    /**
     * Hinernate Factory close test
     */
    @AfterClass
    public static void clean() {
        HibernateUtil.close();
    }
}
