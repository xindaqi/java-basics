package common.constant;

/**
 * 配置参数常量.
 *
 * @author xindaqi
 * @date 2021-07-19 16:51
 */
public class ConfigConstant {

    /**
     * Redis连接池最大连接数
     */
    public static final int REDIS_POOL_MAX_NUM = 30;

    /**
     * Redis连接池空闲连接数
     */
    public static final int REDIS_POOL_IDLE_NUM = 10;

    /**
     * Redis主机地址
     */
    public static final String REDIS_HOST = "localhost";

    /**
     * Redis密码
     */
    public static final String REDIS_PWD = "123456";

    /**
     * Redis端口
     */
    public static final int REDIS_PORT = 6379;

    /**
     * Redis超时时间：2000ms
     */
    public static final int REDIS_TIMEOUT = 2000;

    /**
     * Redis数据库：0
     */
    public static final int REDIS_DATABASE_0 = 0;

    private ConfigConstant() {
        throw new AssertionError(ConfigConstant.class.getName() + StringConstant.PRIVATE_INSTANCE_ERROR);
    }

}
