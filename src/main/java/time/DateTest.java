package time;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Date测试.
 *
 * @author xindaqi
 * @since 2021/2/22 15:32
 */
public class DateTest {
    private static final Logger logger = Logger.getLogger("DateTest");

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        logger.info("时间戳：" + time);

        long timeFromDate = new Date().getTime();
        logger.info("Date时间戳：" + timeFromDate);

    }


}
