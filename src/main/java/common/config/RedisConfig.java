package common.config;

import common.constant.ConfigConstant;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池配置.
 *
 * @author xindaqi
 * @date 2021-07-19 16:52
 */
public class RedisConfig {

    /**
     * Jedis连接池配置
     */
    private static JedisPoolConfig jedisPoolConfig;

    /**
     * Jedis连接池
     */
    private static JedisPool jedisPool;

    static {
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(ConfigConstant.REDIS_POOL_IDLE_NUM);
        jedisPoolConfig.setMaxTotal(ConfigConstant.REDIS_POOL_MAX_NUM);
        jedisPool = new JedisPool(jedisPoolConfig, ConfigConstant.REDIS_HOST, ConfigConstant.REDIS_PORT, ConfigConstant.REDIS_TIMEOUT, ConfigConstant.REDIS_PWD, ConfigConstant.REDIS_DATABASE_0);
    }

    /**
     * 获取连接池.
     *
     * @return jedis连接池
     */
    public static JedisPool getRedisPool() {
        return jedisPool;
    }

}
