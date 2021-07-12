package thirdparty;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import common.constant.DigitalConstant;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

/**
 * Guava缓存测试样例.
 *
 * @author xindaqi
 * @date 2021-07-12 17:44
 */
public class GuavaTest {

    private static final Logger logger = Logger.getLogger("GuavaTest");

    /**
     * 测试Guava Cache
     */
    public static void cacheTest() {
        try {
            Cache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(DigitalConstant.ONE).maximumSize(DigitalConstant.TWO).build();
            cache.put("1", "xiaoxiao");
            cache.put("2", "xiaolan");
            cache.put("3", "xiaohua");
            logger.info("cache；" + cache + ",cache size:" + cache.size());
            String val1 = cache.get("1", () -> {
                String value1 = "value1";
                return value1;
            });
            String val3 = cache.get("3", new Callable<String>() {
                public String call() {
                    String anotherValue = "value3";
                    return anotherValue;
                }
            });
            logger.info("cache key1:" + val1);
            logger.info("cache key3:" + val3);
        } catch(Exception e) {
            logger.info("Guava cache异常：" + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试LoadCache
     */
    public static void loadCacheTest() {
        try {
            LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(DigitalConstant.TWO).build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String number) throws Exception {
                            return "anotherVal";
                        }
                    }
            );
            cache.put("1", "xiaoxiao");
            cache.put("2", "xiaohua");
            cache.put("3", "xiaotian");
            logger.info("load cache key1:" + cache.get("1"));
            logger.info("load cache key3:" + cache.get("3"));
        } catch(Exception e) {
            logger.info("LoadCache异常：" + e);
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        cacheTest();
        loadCacheTest();
    }
}
