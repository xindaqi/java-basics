package datastructure;

import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Set.
 *
 * @author xindaqi
 * @since 2021/3/15 19:38
 */
public class SetTest {

    private static final Logger logger = Logger.getLogger("SetTest");

    public static void main(String[] args) {
        Set set = Stream.of("aaa", "bbb", "ccc", "aaa").collect(Collectors.toSet());
        logger.info("我是Set：" + set);

    }
}
