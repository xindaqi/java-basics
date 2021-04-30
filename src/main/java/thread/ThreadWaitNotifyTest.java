package thread;

import java.util.logging.Logger;

/**
 * Wait, Notify测试.
 *
 * @author xindaqi
 * @since 2021/4/16 17:28
 */
public class ThreadWaitNotifyTest {

    private static final Logger logger = Logger.getLogger("ThreadWaitNotifyTest");

    private final Object flag = new Object();

    class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 1; i <= 4; i += 2) {
                    flag.notify();
                    logger.info("奇数：" + i);
                }
                try {
                    logger.info("进入ThreadA wait");
                    flag.wait();
                    logger.info("重新进入ThreadA");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (flag) {
                for (int i = 2; i <= 4; i += 2) {
                    flag.notify();
                    logger.info("偶数：" + i);
                    if (i == 4) {
                        logger.info("退出当前线程");
                        Thread.currentThread().interrupt();
                    }
                }
                try {
                    logger.info("进入ThreadB wait");
                    flag.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadWaitNotifyTest threadWaitNotifyTest = new ThreadWaitNotifyTest();
        ThreadA threadA = threadWaitNotifyTest.new ThreadA();
        threadA.start();
        ThreadB threadB = threadWaitNotifyTest.new ThreadB();
        threadB.start();
    }
}
