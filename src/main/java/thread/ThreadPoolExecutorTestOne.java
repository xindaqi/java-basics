package thread;

import java.util.concurrent.*;
import java.util.logging.Logger;

import static common.constant.DigitalConstant.*;

/**
 * ThreadPoolExecutor测试.
 *
 * @author xindaqi
 * @date 2021-04-28 17:58
 */
public class ThreadPoolExecutorTestOne {

    private static Logger logger = Logger.getLogger("ThreadPoolExecutorTestOne");

    /**
     * 有返回值测试.
     *
     * @return
     * @throws InterruptedException
     */
    private static String testWithReturn() throws InterruptedException {
        logger.info("当前线程：" + Thread.currentThread().getName());
        Thread.sleep(FIVE*THOUSAND_L);
        return Thread.currentThread().getName();
    }

    /**
     * 无返回值测试.
     *
     * @return
     * @throws InterruptedException
     */
    private static String testWithoutReturn() throws InterruptedException {
        logger.info("当前线程：" + Thread.currentThread().getName());
        Thread.sleep(FIVE*THOUSAND_L);
        return Thread.currentThread().getName();
    }

    public static void AsynchronizedTest(ExecutorService executorService, Integer flag) {
        switch(flag) {
            case ONE:
                try {
                    Future<String> future = executorService.submit(() -> testWithReturn());
                    logger.info("Future content:" + future.get());
                    logger.info("我有返回值，是同步");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } finally {
                    executorService.shutdown();
                    break;
                }
            case TWO:
                try {
                    executorService.submit(() -> testWithoutReturn());
                    logger.info("我没有返回值，是异步");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    executorService.shutdown();
                    break;
                }
            default:
                logger.info("不匹配");
        }

    }
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                THREE,
                FIVE,
                THOUSAND_L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(TWO),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
//        AsynchronizedTest(threadPoolExecutor, ONE);
        AsynchronizedTest(threadPoolExecutor, TWO);

    }

}
