package lock;

import java.util.logging.Logger;

/**
 * 非synchronized测试.
 *
 * @author xindaqi
 * @since 2021/4/13 17:49
 */
public class WithoutSynchronizedTest implements Runnable {

    private static final Logger logger = Logger.getLogger("SynchronizedTest");

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void add() throws InterruptedException {
        logger.info("执行add()方法的Thread:" + Thread.currentThread().getName());
        logger.info("开始执行add()方法");
        Thread.sleep(1000);
        logger.info("开始执行delete()方法");
        delete();
        logger.info("完成add()方法执行");
    }

    public void delete() throws InterruptedException {
        logger.info("执行delete()方法的Thread:" + Thread.currentThread().getName());
        logger.info("开始执行delete()方法");
        Thread.sleep(1000);
        logger.info("完成delete()方法执行");
    }

    public static void main(String[] args) {
        try {

            WithoutSynchronizedTest withoutSynchronizedTest = new WithoutSynchronizedTest();
            Thread thread1 = new Thread(withoutSynchronizedTest, "thread1");
            Thread thread2 = new Thread(withoutSynchronizedTest, "thread2");
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
