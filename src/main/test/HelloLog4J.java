import org.apache.log4j.Appender;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/7/26.
 */
public class HelloLog4J {
    private static Logger logger = LoggerFactory.getLogger("view");

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        logger.info("123","appender2");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录warn级别的信息
        logger.warn("This is warn message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
