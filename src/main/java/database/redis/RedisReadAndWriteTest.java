package database.redis;

import common.config.RedisConfig;
import redis.clients.jedis.Jedis;

//import java.util.logging.Logger;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Redis读写测试样例.
 *
 * @author xindaqi
 * @date 2021-07-19 16:56
 */
public class RedisReadAndWriteTest {

    private static final Logger logger = LogManager.getLogger(RedisReadAndWriteTest.class);

    /**
     * 读取Redis数据.
     */
    public static void readDataInRedis(String key) {
        Jedis jedis = null;
        try {
            jedis = RedisConfig.getRedisPool().getResource();
            jedis.set("tutorial", "Java");
            String value = jedis.get(key);
            logger.info("Key:{}, value:{}", key, value);
        } catch(Exception e) {
            logger.error(">>>>>>>>异常--Redis读取数据：", e);
            throw new RuntimeException(e);
        } finally {
            assert jedis != null;
            jedis.close();
        }
    }

    /**
     * 存储数据到Redis.
     *
     * @param key 键
     * @param value 值
     */
    public static void writeDataInRedis(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = RedisConfig.getRedisPool().getResource();
            jedis.set(key, value);
        } catch(Exception e) {
            logger.error(">>>>>>>>>>异常--写入Redis：", e);
            throw new RuntimeException(e);
        } finally {
            assert jedis != null;
            jedis.close();
        }
    }

    public static void main(String[] args) {

        try {
            writeDataInRedis("u123", "xiaohua");
            readDataInRedis("u123");
        } catch(Exception e) {
            logger.error(">>>>>>>>>>异常--main：", e);
            throw new RuntimeException(e);
        }

    }
}
