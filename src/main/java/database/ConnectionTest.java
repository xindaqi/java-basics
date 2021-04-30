package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import static common.constant.DatabaseConstant.MY_SQL;

/**
 * 数据库连接测试.
 *
 * @author xindaqi
 * @date 2021-04-29 18:24
 */
public class ConnectionTest {

    private static final Logger logger = Logger.getLogger("ConnectionTest");

    DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
    IDatabaseConnection databaseConnection = databaseConnectionFactory.databaseConnection(MY_SQL);
    Connection conn = databaseConnection.databaseLink();
    Statement stmt = null;

    public void query() {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT id, region_id, region_code, region_name FROM db_monkey_run.region";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String regionId = rs.getString("region_id");
                String regionCode = rs.getString("region_code");
                String regionName = rs.getString("region_name");
                logger.info("id:" + id + ",regionId:" + regionId + ",regionCode:" + regionCode + ",regionName:" + regionName);
            }
            rs.close();

        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se1) {
                throw new RuntimeException(se1);
            }
        }

    }

    public static void main(String[] args) {
        ConnectionTest connectionTest = new ConnectionTest();
        connectionTest.query();
    }


}
