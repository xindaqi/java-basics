package thread;

import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * ThreadLocal测试.
 *
 * @author xindaqi
 * @since 2021/4/14 17:01
 */
public class ThreadLocalTest implements Runnable {

    private static int m = 0;
    private static int n = 0;

    private static final Logger logger = Logger.getLogger("ThreadLocalTest");

    /**
     * 主线程创建ThreadLocal，子线程读取
     */
    public static void threadLocalReadInAnotherThread() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        logger.info("Thread:" + Thread.currentThread().getName());
        threadLocal.set("我是主线程");
        Thread thread1 = new Thread(() -> {
            logger.info("Thread:" + Thread.currentThread().getName() + threadLocal.get());
            threadLocal.remove();
        });
        thread1.start();
    }

    /**
     * 主线程创建InheritableThreadLocal，子线程读取
     */
    public static void inheritableThreadLocalReadInAnotherThread() {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        logger.info("Thread:" + Thread.currentThread().getName());
        threadLocal.set("我是主线程");
        Thread thread = new Thread(() -> {
            logger.info("Thread:" + Thread.currentThread().getName() + threadLocal.get());
            threadLocal.remove();
        });
        thread.start();
    }

    /**
     * ThreadLocal通用功能测试
     */
    public static void threadLocalNormal() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("我是ThreadLocal存储的数据");
        logger.info("Thread:" + Thread.currentThread().getName() + threadLocal.get());
        threadLocal.remove();
    }

    /**
     * 固定线程数线程池结合InheritableThreadLocal测试，
     * 无法在同一子线程为ThreadLocal设置值
     */
    public static void threadPoolWithInheritableThreadLocal() {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("我是主线程1");

        ExecutorService exs = Executors.newFixedThreadPool(1);
        exs.submit(() -> {
            threadLocalValueSync(threadLocal);
        });
        threadLocal.set("我是主线程2");
        exs.submit(() -> {
            threadLocalValueSync(threadLocal);
        });
        threadLocalValueSync(threadLocal);
        exs.shutdown();
    }

    /**
     * ThreadPoolExecutor线程池结合InheritableThreadLocal测试，
     * 直接在线程池中使用ThreadLocal，避免父子线程传值问题
     */
    public static void threadPoolExecutorWithInheritableThreadLocal() {
        int corePoolSize = 3;
        int maximumPoolSize = 5;
        long keepAliveTime = 1000;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 4; i++) {
            threadPoolExecutor.execute(new ThreadLocalTest());
        }

        threadPoolExecutor.shutdown();

    }

    /**
     * 重写Runnable方法
     */
    @Override
    public void run() {
        try {
            /**
             * 使用synchronized关键字
             */
            ThreadLocal<String> threadLocalFromTest = testSync();
            /**
             * 不使用synchronized关键字
             */
//            ThreadLocal<String> threadLocalFromTest = test();
            n += 1;
            threadLocalFromTest.set("我是主线程run:" + n);
            logger.info("Thread run: " + Thread.currentThread().getName() + threadLocalFromTest.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 使用InheritableThreadLocal创建线程存储
     * synchronized保证原子性
     *
     * @return 线程存储对象
     * @throws InterruptedException
     */
    public static synchronized ThreadLocal<String> testSync() throws InterruptedException {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        m += 1;
        threadLocal.set("我是主线程test:" + m);
        logger.info("Thread test: " + Thread.currentThread().getName() + threadLocal.get());
        return threadLocal;
    }

    /**
     * 使用InheritableThreadLocal创建线程存储
     *
     * @return 线程存储对象
     * @throws InterruptedException
     */
    public static ThreadLocal<String> test() throws InterruptedException {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("我是主线程1");
        logger.info("Thread test: " + Thread.currentThread().getName() + threadLocal.get());
        return threadLocal;
    }

    public static synchronized void threadLocalValueSync(ThreadLocal threadLocal) {
        logger.info("Thread:" + Thread.currentThread().getName() + threadLocal.get());
    }

    public static void threadLocalValue(ThreadLocal threadLocal) {
        logger.info("Thread:" + Thread.currentThread().getName() + threadLocal.get());
    }


    public static void main(String[] args) {
//        ThreadLocalTest.threadLocalReadInAnotherThread();
//        ThreadLocalTest.inheritableThreadLocalReadInAnotherThread();
//        ThreadLocalTest.threadLocalNormal();
//        ThreadLocalTest.threadPoolWithInheritableThreadLocal();
        ThreadLocalTest.threadPoolExecutorWithInheritableThreadLocal();
    }
}
