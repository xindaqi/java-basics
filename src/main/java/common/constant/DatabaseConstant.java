package common.constant;

import static common.constant.StringConstant.PRIVATE_INSTANCE_ERROR;

/**
 * 数据库配置信息常量.
 *
 * @author xindaqi
 * @date 2021-04-29 18:12
 */
public class DatabaseConstant {

    /**
     * JDBC驱动
     */
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 数据库连接地址
     */
    public static final String DB_URL = "jdbc:mysql://localhost:3306/db_monkey_run?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";

    /**
     * 数据库用户名
     */
    public static final String DB_MYSQL_USER_NAME = "root";

    /**
     * 数据库密码
     */
    public static final String DB_MYSQL_PASSWORD = "123456";

    /**
     * MySQL数据库
     */
    public static final String MY_SQL = "mysql";

    private DatabaseConstant() {
        throw new AssertionError(DatabaseConstant.class.getName() + PRIVATE_INSTANCE_ERROR);
    }

}
