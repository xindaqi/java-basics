package thirdparty;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import common.constant.DigitalConstant;

import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

/**
 * Guava Cache测试样例.
 *
 * @author xindaqi
 * @date 2021-07-19 16:46
 */
public class GuavaCacheTest {

    private static final Logger logger = Logger.getLogger("GuavaCacheTest");

    /**
     * 缓存：Cache
     */
    private static Cache<String, String> cache = CacheBuilder.newBuilder()
            .initialCapacity(DigitalConstant.ONE)
            .maximumSize(DigitalConstant.TWO)
            .build();


    /**
     * 初始化Cache.
     *
     * @return 默认值
     */
    private static String initializeCache() {
        cache.put("1", "xiaohua");
        cache.put("2", "xiaolan");
        cache.put("3", "xiaoxiao");
        logger.info("Load cache for initial");
        return "xiaoxin";
    }

    /**
     * 刷新Cache.
     *
     * @return 默认值
     */
    private static String reloadCache() {
        cache.put("1", "xiaohuahua");
        cache.put("2", "xiaolanlan");
        cache.put("3", "xiaoxiaoxiao");
        logger.info("Reload cache for refresh");
        return "xiaoxinxin";
    }

    /**
     * Cache默认值.
     *
     * @return 默认值
     */
    private static String cacheDefault() {
        return "xiaoxin";
    }

    /**
     * 读取Cache
     */
    private static void readCache() {
        initializeCache();
        String val1 = cache.getIfPresent("1");
        logger.info("key1, value1:" + val1);

        String val2 = cache.getIfPresent("2");
        logger.info("key2, value2:" + val2);

        try {
            String val1Get = cache.get("1", GuavaCacheTest::cacheDefault);
            logger.info("val1:" + val1Get);
        } catch(ExecutionException ee) {
            throw new RuntimeException(ee);
        }
    }


    public static void main(String[] args) {

        readCache();

    }
}
