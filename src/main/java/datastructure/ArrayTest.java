package datastructure;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * 数组测试.
 *
 * @author xindaqi
 * @since 2021/2/22 10:42
 */
public class ArrayTest {

    private static final Logger logger = Logger.getLogger("ArrayTest");

    public static void main(String[] args) {
        String[] v1 = {"1", "2", "3"};
        String testStr = "https://bqx-oss-test.oss-cn-shenzhen.aliyuncs.com/test-prefix/2321ac74";
//        String testStr = "a.b.c";
        String[] testArr1 = testStr.split("\\.");
        Stream<String> stream1 = Arrays.stream(testArr1);
        stream1.forEach(s -> logger.info("data:" + s));
        String[] testArr2 = StringUtils.split(testStr, ".");
        Stream<String> stream2 = Arrays.stream(testArr2);
        stream2.forEach(s -> logger.info("data2:" + s));
    }
}
