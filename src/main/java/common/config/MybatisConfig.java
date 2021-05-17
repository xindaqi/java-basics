package common.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

import static common.constant.DatabaseConstant.MYBATIS_CONFIG_PATH;

/**
 * Mybatis配置.
 *
 * @author xindaqi
 * @date 2021-05-14 16:16
 */
public class MybatisConfig {

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream mybatisConfigInputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
        return new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
    }
}
