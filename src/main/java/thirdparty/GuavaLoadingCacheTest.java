package thirdparty;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import common.constant.BooleanConstant;
import common.constant.DigitalConstant;

import java.util.concurrent.*;
import java.util.logging.Logger;

import static common.constant.DigitalConstant.*;
import static common.constant.DigitalConstant.TWO;

/**
 * Guava LoadingCache测试样例.
 *
 * @author xindaqi
 * @date 2021-07-19 16:47
 */
public class GuavaLoadingCacheTest {

    private static final Logger logger = Logger.getLogger("GuavaLoadingCacheTest");

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
     * Guava线程池
     */
    private static ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(threadPoolExecutorGenerate);

    /**
     * 建造LoadingCache，
     * 使用ThreadPoolExecutor线程池异步刷新数据
     */
    public static LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
//            .refreshAfterWrite(3, TimeUnit.SECONDS)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    logger.info(">>>>>>>>>>>Load");
                    return initializeCache();
                }

                @Override
                public ListenableFuture<String> reload(String key, String oldValue)
                        throws Exception {
                    logger.info(">>>>>>>>>>Reload");
                    ListenableFutureTask<String> task = ListenableFutureTask
                            .create(GuavaLoadingCacheTest::reloadCache);
                    Future future = threadPoolExecutorGenerate.submit(task);
                    try {
                        future.get(DigitalConstant.TWO, TimeUnit.SECONDS);
                        return task;
                    } catch(TimeoutException te) {
                        future.cancel(BooleanConstant.TRUE);
                        logger.info(">>>>>>>>>超时--线程池：" + te);
                        return task;
                    } catch(InterruptedException ie) {
                        future.cancel(BooleanConstant.TRUE);
                        logger.info(">>>>>>>>>中断--线程池线程：" + ie);
                        return task;
                    } catch(Exception e) {
                        future.cancel(BooleanConstant.TRUE);
                        logger.info(">>>>>>>>>>异常--线程池：" + e);
                        return task;
                    }
                }
            });

    /**
     * 建造LoadingCache，
     * 使用Guava线程池异步刷新数据
     */
    public static LoadingCache<String, String> loadingCacheAnother = CacheBuilder.newBuilder()
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .expireAfterWrite(60, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return initializeCache();
                }

                @Override
                public ListenableFuture<String> reload(String key, String oldValue)
                        throws Exception {
                    return listeningExecutorService.submit(GuavaLoadingCacheTest::reloadCache);
                }
            });


    /**
     * 初始化Cache.
     *
     * @return 默认值
     */
    private static String initializeCache() {
        loadingCache.put("1", "xiaohua");
        loadingCache.put("2", "xiaolan");
        loadingCache.put("3", "xiaoxiao");
        logger.info(">>>>>>>>>>Load cache thread:" + Thread.currentThread().getName());
        return "xiaoxin";
    }

    /**
     * 刷新Cache.
     *
     * @return 默认值
     */
    private static String reloadCache() {
        loadingCache.put("1", "xiaohuahua");
        loadingCache.put("2", "xiaolanlan");
        loadingCache.put("3", "xiaoxiaoxiao");
        logger.info(">>>>>>>>>>Reload cache thread:" + Thread.currentThread().getName());
        /**
         * 线程池超时测试,
         * 设置的线程超时为：2秒，
         * 测试时设置大于2000即可
         */
        myTimeSleep(1000);
        return "xiaoxinxin";
    }

    /**
     * 读取Cache,通过load初始化
     */
    private static void readCacheSelfInitialize() {
        String val1 = loadingCache.getIfPresent("1");
        logger.info("key1, value1:" + val1);

        String val2 = loadingCache.getIfPresent("2");
        logger.info("key2, value2:" + val2);

        try {
            String val1Get = loadingCache.get("1");
            logger.info("val1:" + val1Get);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }
    }

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

    /**
     * 读取Cache,通过reload刷新数据
     */
    private static void readCacheSelfRefreshTest() {

        String val0 = loadingCache.getIfPresent("2");
        logger.info("key1, value1:" + val0);
        logger.info(">>>>>>>>>>>>>>>>>>Read cache thread:" + Thread.currentThread().getName() + ",map size:" + loadingCache.asMap().keySet() + ",data:" + loadingCache.asMap());

        myTimeSleep(2000);
    }

    public static void main(String[] args) {

//        readCacheSelfInitialize();
        try {
            String val1Get = loadingCache.get("0");
            logger.info("val1:" + val1Get);
            logger.info(">>>>>>>>>>>>>>>>>>|||||cache size:" + loadingCache.size());
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }

        for(int i=0; i<100;i++) {
            readCacheSelfRefreshTest();
        }

    }
}
