import org.junit.Test;

/**
 * Created by Taohaowei on 2017/7/26.
 */
public class JustTest {

    @Test
    public void test()
    {
        for (int i=0;i<30;i++) {
            int id = i ^ 3;
            System.out.println(id%4);
        }
    }
}
