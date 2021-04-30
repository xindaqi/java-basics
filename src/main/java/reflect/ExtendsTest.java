package reflect;

import clzz.EngineerUser;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试类集成.
 *
 * @author xindaqi
 * @since 2021/4/16 10:16
 */
public class ExtendsTest {

    private static final Logger logger = Logger.getLogger("ExtendsTest");

    public static void main(String[] args) {
        List<String> languageList = Stream.of("Java", "Python").collect(Collectors.toList());
        EngineerUser engineerUser = new EngineerUser("xiaoxioa",
                "guangdong",
                "male",
                languageList,
                "Senior",
                3);
        logger.info("工程师信息：" + engineerUser);
    }
}
