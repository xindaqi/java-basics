package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static common.constant.DigitalConstant.*;

/**
 * 我是描述信息.
 *
 * @author xindaqi
 * @since 2021/4/15 14:04
 */
public class ThreadPoolExecutorTest implements Runnable {

    private static final Logger logger = Logger.getLogger("ThreadPoolExecutorTest");

    @Override
    public void run() {
        try {
            test();
            logger.info("Thread run: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void test() throws InterruptedException {
        logger.info("Thread test: " + Thread.currentThread().getName());
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                THREE,
                FIVE,
                THOUSAND_L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(TWO),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < FIVE; i++) {
            threadPoolExecutor.execute(new ThreadPoolExecutorTest());
        }
        threadPoolExecutor.shutdown();
    }
}
