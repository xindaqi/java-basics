package database;

import java.sql.Connection;

/**
 * 数据库连接接口.
 *
 * @author xindaqi
 * @date 2021-04-30 11:02
 */
public interface IDatabaseConnection {
    /**
     * 数据库连接.
     *
     * @return 数据库连接对象
     */
    default Connection databaseLink() {
        return null;
    }
}
