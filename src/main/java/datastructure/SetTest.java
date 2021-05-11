package datastructure;

import java.util.HashSet;
import java.util.Iterator;
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

    /**
     * 向set添加元素
     *
     * @param set set集合
     */
    public static void addTest(Set<String> set) {
        set.add("xiaoxiao");
        set.add("xiaohua");
        logger.info("添加元素后的set: " + set);
    }

    /**
     * 删除set元素
     *
     * @param set set集合
     */
    public static void deleteTest(Set<String> set) {
        set.remove("xiaoxiao");
        logger.info("删除元素后的set:" + set);
    }

    /**
     * 查询set是否含有某个元素
     *
     * @param set set集合
     */
    public static void queryTest(Set<String> set) {
        logger.info("查询set是否含有xiaohua元素：" + set.contains("xiaohua"));
    }

    /**
     * 查询set元素数量
     *
     * @param set set集合
     */
    public static void sizeTest(Set<String> set) {
        logger.info("Set内容数量：" + set.size());
    }

    /**
     * 清除set全部内容
     *
     * @param set set结合
     */
    public static void clearTest(Set<String> set) {
        set.clear();
        logger.info("清除set内容：" + set);
    }

    /**
     * 判断set是否为空
     *
     * @param set set集合
     */
    public static void emptyTest(Set<String> set) {
        logger.info("判断set是否为空：" + set.isEmpty());
    }

    /**
     * set遍历：forEach
     *
     * @param set set集合
     */
    public static void forEachTest(Set<String> set) {
        set.forEach(s -> {
            logger.info("set内容：" + s);
        });
    }

    /**
     * set遍历：iterator
     *
     * @param set
     */
    public static void iteratorTest(Set<String> set) {
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String value = it.next();
            logger.info("set内容：" + value);
        }
    }

    public static void main(String[] args) {
        Set<String> set = Stream.of("aaa", "bbb", "ccc", "aaa").collect(Collectors.toSet());
        logger.info("我是Set：" + set);
        Set<String> setTemp = new HashSet();
        addTest(setTemp);
        forEachTest(setTemp);
        iteratorTest(setTemp);
        deleteTest(setTemp);
        queryTest(setTemp);
        emptyTest(setTemp);
        clearTest(setTemp);
        sizeTest(setTemp);
        emptyTest(setTemp);

    }
}
