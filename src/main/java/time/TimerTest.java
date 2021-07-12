package time;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

/**
 * 定时器测试样例.
 *
 * @author xindaqi
 * @date 2021-07-12 17:29
 */
public class TimerTest {

    private static Timer timer = new Timer();

    private static final Logger logger = Logger.getLogger("TimerTest");

    static class TimerTaskTest extends TimerTask {

        @Override
        public void run() {
            logger.info("我是定时测试");
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 2);
        logger.info("start");
        /**
         * 参数1：定时任务方法
         * 参数2：初始延迟，即延时指定的时间后，开始执行定时任务
         * 参数3：定时任务执行周期，即定时任务多长时间执行一次
         */
        timer.schedule(new TimerTaskTest(), calendar.getTime(), 3L*1000L);
    }
}