package database.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static common.constant.DatabaseConstant.MY_SQL;

/**
 * 数据库连接测试.
 *
 * @author xindaqi
 * @date 2021-04-29 18:24
 */
public class ConnectionTest {

    private static final Logger logger = Logger.getLogger("ConnectionTest");

    /**
     * 拼接SQL where in查询语句
     *
     * @param whereIn where in 语句，
     *                语句从SELECT开始，到IN结束
     *                如SELECT * FROM tb_test WHERE id IN
     * @param params 查询的参数列表
     * @return 完整的SQL语句
     */
    public String generateSqlWhenUsingIn(String whereIn, List<?> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(whereIn).append(" (");
        params.stream().forEach(e -> {
            sb.append(e);
            sb.append(",");
        });
        /**
         * 删除最后一个逗号：12,13,
         * 处理为：12,13
         */
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public void queryUserById(String sql) {
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        IDatabaseConnection databaseConnection = databaseConnectionFactory.databaseConnection(MY_SQL);
        Connection conn = databaseConnection.databaseLink();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String userId = rs.getString("user_id");
                String username = rs.getString("username");
                logger.info("用户信息id:" + id + ",userId:" + userId + ",username:" + username);
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

    public void query() {
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        IDatabaseConnection databaseConnection = databaseConnectionFactory.databaseConnection(MY_SQL);
        Connection conn = databaseConnection.databaseLink();
        Statement stmt = null;
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
        List<Integer> idList = Stream.of(1, 2, 3).collect(Collectors.toList());
        String sqlPrefix = "SELECT id, user_id, username FROM db_monkey_run.tb_user WHERE id IN";
        String sql = connectionTest.generateSqlWhenUsingIn(sqlPrefix, idList);
        connectionTest.queryUserById(sql);
    }

}
