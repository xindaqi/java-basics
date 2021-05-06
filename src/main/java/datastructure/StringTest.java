package datastructure;

import java.util.logging.Logger;

/**
 * 字符串测试.
 *
 * @author xindaqi
 * @date 2021-05-06 18:49
 */
public class StringTest {

    private static final Logger logger = Logger.getLogger("StringTest");

    public static void main(String[] args) {

        String a = null;
        String c = String.valueOf(a);
        logger.info("String.valueOf测试null转换：" + c);
//        String d = a.toString();
//        logger.info("toString测试null转换： " + d);
//        String b = String.valueOf(null);
//        logger.info("String.valueOf测试null转换：" + b);

    }
}
