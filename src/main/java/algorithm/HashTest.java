package algorithm;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hash测试样例.
 *
 * @author xindaqi
 * @date 2021-07-12 17:37
 */
public class HashTest {

    private static final Logger logger = Logger.getLogger("HashTest");

    public static void main(String[] args) {
        List<String> randomStringList = Stream.of("3a6461", "940c7c", "4b1422", "c5781c", "e5db84").collect(Collectors.toList());
        randomStringList.forEach( s ->
                logger.info("s.hashCode:" + s.hashCode())
        );
    }
}
