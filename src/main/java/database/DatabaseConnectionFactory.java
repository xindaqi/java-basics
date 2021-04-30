package database;

import static common.constant.DatabaseConstant.MY_SQL;

/**
 * 数据库连接工厂.
 *
 * @author xindaqi
 * @date 2021-04-30 11:16
 */
public class DatabaseConnectionFactory {
    public IDatabaseConnection databaseConnection(String databaseName) {
        switch(databaseName) {
            case MY_SQL:
                return new MySqlConnection();
            default:
                return null;
        }
    }
}
