package database;

import database.dao.UserDAO;
import database.dto.UserOutputDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * MyBatis CURD测试.
 *
 * @author xindaqi
 * @date 2021-05-14 16:33
 */
public class MyBatisTest {

    private static final Logger logger = Logger.getLogger("MyBatisTest");

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            List<UserOutputDTO> userOutputDTOList = userDAO.queryUserByPage();
            logger.info("我是用户信息列表：" + userOutputDTOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }
}
