package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static common.constant.DatabaseConstant.*;

/**
 * 连接MySQL数据库.
 *
 * @author xindaqi
 * @date 2021-04-30 11:06
 */
public class MySqlConnection implements IDatabaseConnection {

    @Override
    public Connection databaseLink() {
        try {
            /**
             * 注册MySQL驱动
             */
            Class.forName(JDBC_MYSQL_DRIVER);
            return DriverManager.getConnection(DB_MYSQL_URL, DB_MYSQL_USER_NAME, DB_MYSQL_PASSWORD);
        } catch(SQLException se) {
            throw new RuntimeException(se);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
