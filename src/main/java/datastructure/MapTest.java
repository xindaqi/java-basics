package datastructure;

import common.constant.IntConstant;
import common.entity.UserEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Map测试.
 *
 * @author xindaqi
 * @since 2021/2/22 10:45
 */
public class MapTest {

    private static final Logger logger = Logger.getLogger("MapTest");

    /**
     * foreach遍历Map
     *
     * @param map map对象
     */
    private static void forEachMap(Map<String, Object> map) {
        logger.info("forEach遍历Map");
        map.forEach((k, v) -> {
            logger.info("id:" + k);
            logger.info("user information: " + v);
        });
    }

    /**
     * Iterator遍历Map
     *
     * @param map map对象
     */
    private static void iteratorMap(Map<String, Object> map) {
        logger.info("Iterator遍历Map");
        Iterator<Map.Entry<String, Object>> its = map.entrySet().iterator();
        while (its.hasNext()) {
            Map.Entry<String, Object> it = its.next();
            logger.info("key:" + it.getKey());
            logger.info("value:" + it.getValue());
        }
    }

    /**
     * entrySet遍历Map
     *
     * @param map map对象
     */
    private static void entrySetMap(Map<String, Object> map) {
        logger.info("entrySet遍历Map");
        for (Map.Entry<String, Object> m : map.entrySet()) {
            logger.info("key: " + m.getKey());
            logger.info("value: " + m.getValue());
        }
    }

    /**
     * keySet获取Map键集合
     *
     * @param map map对象
     */
    private static void keySet(Map<String, Object> map) {
        logger.info("获取Map的key集合");
        Set<String> keySet = map.keySet();
        logger.info("key set: " + keySet);
    }

    /**
     * values获取Map值集合
     *
     * @param map map对象
     */
    private static void valueCollection(Map<String, Object> map) {
        logger.info("获取Map的value集合");
        Collection values = map.values();
        values.isEmpty();
        logger.info("values: " + values);
    }

    private static void concurrentHashMapTest() {
        Map<String, String> map = new ConcurrentHashMap<>(2);
    }

    public static void main(String[] args) {
        logger.info("我是Map测试");
        UserEntity userEntity1 = new UserEntity("0001", "xiaoxiao", "male");
        UserEntity userEntity2 = new UserEntity("0002", "xiaohua", "female");
        UserEntity userEntity3 = new UserEntity("0003", "xiaoer", "male");
        /**
         * 初始因子计算：
         * 公式：需要存储的元素个数 ÷ 负载因子 ＋ 1
         * 默认负载因子：0.75
         * 3 ÷ 0.75 + 1
         */
        Map<String, Object> userEntityMap = new HashMap<>(IntConstant.FIVE);
        userEntityMap.put("1", userEntity1);
        userEntityMap.put("2", userEntity2);
        userEntityMap.put("3", userEntity3);
        forEachMap(userEntityMap);

        Map<String, Object> map = new HashMap<>(IntConstant.FIVE);
        map.put("name", "xiaohua");
        map.put("address", "Earth");
        map.put("hobb", "play");
        map.put("age", 250);

        iteratorMap(map);
        entrySetMap(map);
        keySet(map);
        valueCollection(map);

    }
}
