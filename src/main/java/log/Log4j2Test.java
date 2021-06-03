package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 我是描述信息.
 *
 * @author xindaqi
 * @date 2021-06-03 11:26
 */
public class Log4j2Test {

    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        String info = "slf4j";
        logger.info("测试: {}", info);
    }
}
