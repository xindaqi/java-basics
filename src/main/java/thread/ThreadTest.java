package thread;

import java.lang.Thread;
import java.util.logging.Logger;

/**
 * 继承Thread类：新建线程
 *
 * @author xindaqi
 * @since 2020-10-10
 */

public class ThreadTest extends Thread {

    private static final Logger logger = Logger.getLogger("ThreadTest");

    private final Object flag = new Object();

    private final int COUNT = 5;

    public ThreadTest() {
    }

    /**
     * 重写run()方法
     */
    @Override
    public void run() {
        synchronized (flag) {
            for (int i = 0; i < COUNT; i++) {
                flag.notify();
                logger.info("线程唤醒，数字：" + i);
                // 输出当前线程
                logger.info("Thread:" + Thread.currentThread() + ":" + i);
                if (i == 4) {
                    logger.info("退出线程");
                    Thread.currentThread().interrupt();
                }
            }
            try {
                flag.wait();
                /**
                 * 线程休眠：200毫秒
                 * 调用本地方法
                 */
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }

    public static void main(String[] args) {
        /**
         * 类实例化
         * 新建线程thread1和thread2
         */
        ThreadTest thread1 = new ThreadTest();
        ThreadTest thread2 = new ThreadTest();
        /**
         * 线程执行
         * 调用同步方法（synchronized）start(),
         * 该同步方法调用本地方法start0()
         */
        thread1.start();
        thread2.start();

    }

}