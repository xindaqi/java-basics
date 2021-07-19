package time;

import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Calender测试样例.
 *
 * @author xindaqi
 * @date 2021-07-19 16:44
 */
public class CalendarTest {

    private static final Logger logger = Logger.getLogger("CalendarTest");

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int currentMinute = calendar.get(Calendar.MINUTE);
        logger.info("Current minute:" + currentMinute);
    }

}
