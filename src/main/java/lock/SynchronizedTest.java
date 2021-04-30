package lock;

import java.util.logging.Logger;

/**
 * Synchronized测试.
 *
 * @author xindaqi
 * @since 2021/4/13 17:01
 */
public class SynchronizedTest implements Runnable {

    private static final Logger logger = Logger.getLogger("SynchronizedTest");

    @Override
    public void run() {
        try {
            add();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public synchronized void add() throws InterruptedException {
        logger.info("执行add()方法的Thread:" + Thread.currentThread().getName());
        logger.info("开始执行add()方法");
        Thread.sleep(1000);
        logger.info("开始执行delete()方法");
        delete();
        logger.info("完成add()方法执行");
    }

    public synchronized void delete() throws InterruptedException {
        logger.info("执行delete()方法的Thread:" + Thread.currentThread().getName());
        logger.info("开始执行delete()方法");
        Thread.sleep(1000);
        logger.info("完成delete()方法执行");
    }

    public static void main(String[] args) {
        try {

            SynchronizedTest synchronizedTest = new SynchronizedTest();
            Thread thread1 = new Thread(synchronizedTest, "thread1");
            Thread thread2 = new Thread(synchronizedTest, "thread2");
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
