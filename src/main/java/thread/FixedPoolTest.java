package thread;

// 引入ExecutorService类

import java.util.concurrent.ExecutorService;
// 引入Executors类
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * 线程池：新建固定数量的线程
 *
 * @author xindaqi
 * @since 2020-10-10
 */
public class FixedPoolTest {

    private static final Logger logger = Logger.getLogger("FixedPoolTest");

    private static final int COUNT_1 = 3;
    private static final int COUNT_2 = 2;

    public static void main(String[] args) {
        // 新建线程池：指定线程数量3
        ExecutorService exs = Executors.newFixedThreadPool(3);

        for (int i = 0; i < COUNT_1; i++) {
            /**
             * 提交线程执行任务，
             * 实现Runnable接口，
             * 重写run()方法，
             * 在run()方法中实现逻辑
             */
            exs.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            for (int j = 0; j < COUNT_2; j++) {
                                logger.info("Thread: " + Thread.currentThread() + ",j:" + j);
                            }
                        }
                    }
            );

            exs.submit(() -> {
                for (int j = 0; j < COUNT_2; j++) {
                    logger.info("Thread: " + Thread.currentThread() + ",j:" + j);
                }
            });
        }
        // 关闭线程池
        exs.shutdown();
    }

}