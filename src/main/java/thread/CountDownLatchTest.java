package thread;

import common.constant.BooleanConstant;
import common.constant.DigitalConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static common.constant.DigitalConstant.*;
import static common.constant.DigitalConstant.TWO;

/**
 * CountDownLatch测试样例.
 *
 * @author xindaqi
 * @date 2021-07-26 12:01
 */
public class CountDownLatchTest {

    private static Logger logger = LogManager.getLogger(CountDownLatchTest.class);

    /**
     * 普通线程池：ThreadPoolExecutor
     */
    private static ExecutorService threadPoolExecutorGenerate = new ThreadPoolExecutor(
            THREE,
            FIVE,
            THOUSAND_L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(TWO),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    /**
     * 延时.
     *
     * @param millisecond 毫秒
     */
    public static void myTimeSleep(long millisecond) {
        try {
            Thread.currentThread().sleep(millisecond);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }

    public static List<String> dataOne(CountDownLatch countDownLatch) {
        List<String> list1 = new ArrayList<>();
        myTimeSleep(3000);
        list1.add("1");
        countDownLatch.countDown();
        return list1;
    }

    public static List<String> dataTwo(CountDownLatch countDownLatch) {
        List<String> list2 = new ArrayList<>();
        myTimeSleep(6000);
        list2.add("2");
        countDownLatch.countDown();
        return list2;
    }

    public static void dataOneVoid(CountDownLatch countDownLatch, List<String> list1) {
        long start = System.currentTimeMillis();
        myTimeSleep(3000);
        list1.add("1");
        long timeCost = System.currentTimeMillis() - start;
        logger.info("data one time cost:{}", timeCost);
        countDownLatch.countDown();
    }

    public static void dataTwoVoid(CountDownLatch countDownLatch, List<String> list2) {
        long start = System.currentTimeMillis();
        myTimeSleep(5000);
        list2.add("2");
        long timeCost = System.currentTimeMillis() - start;
        logger.info("data tow time cost:{}", timeCost);
        countDownLatch.countDown();
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(DigitalConstant.TWO);
        long start = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        try {
            Future future1 = threadPoolExecutorGenerate.submit(() -> dataOneVoid(countDownLatch, list1));
            Future future2 = threadPoolExecutorGenerate.submit(() -> dataTwoVoid(countDownLatch, list2));

            try {
                future1.get(2, TimeUnit.SECONDS);
                future2.get(6, TimeUnit.SECONDS);
            } catch(TimeoutException te) {
                future1.cancel(BooleanConstant.TRUE);
                future2.cancel(BooleanConstant.TRUE);
                logger.error(">>>>>>>>>>线程超时：", te);
                throw new RuntimeException(te);
            }

            try {
                countDownLatch.await();
            } catch(Exception e) {
                logger.error(">>>>>>>>>>CountDownLatch异常:", e);
                throw new RuntimeException(e);
            }
            long timeCost = System.currentTimeMillis() - start;
            logger.info(">>>>>>>>>>time cost:{}, data one:{}, data two: {}", timeCost, list1, list2);
        } catch(Exception e) {
            logger.error(">>>>>>>>>>error");
        }

    }
}
