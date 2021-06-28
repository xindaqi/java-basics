package lambda_expression;

import common.entity.UserEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream值传递和引用传递.
 *
 * @author xindaqi
 * @date 2021-06-28 17:14
 */
public class LambdaDataTransmitTest {

    private static final Logger logger = Logger.getLogger("LambdaDataTransmitTest");

    /**
     * 赋值时使用源对象，此时为引用传递，
     * 即修改结果对象时，源对象同步修改
     *
     * @param userEntityList 结果对象
     * @param uidList uid列表
     * @param userEntityMap 源对象
     */
    public static void referenceTest(List<UserEntity> userEntityList, List<String> uidList, Map<String, UserEntity> userEntityMap) {
        userEntityList = uidList.stream().filter(uid -> null != userEntityMap.get(uid)).map(uid -> userEntityMap.get(uid)).collect(Collectors.toList());
        userEntityList.stream().forEach(s -> s.setNickname("foreach"));
        logger.info("userEntity list changed:" + userEntityList);
        logger.info("map changed: " + userEntityMap);
    }

    /**
     * 赋值时新建对象，保证是值传递，
     * 即修改结果对象时，不影响源对象
     *
     * @param userEntityList 结果对象
     * @param uidList uid列表
     * @param userEntityMap 源对象
     */
    public static void valueTest(List<UserEntity> userEntityList, List<String> uidList, Map<String, UserEntity> userEntityMap) {
        userEntityList = uidList.stream().filter(uid -> null != userEntityMap.get(uid)).map(uid -> new UserEntity(userEntityMap.get(uid).getUid(), userEntityMap.get(uid).getNickname(), userEntityMap.get(uid).getSex())).collect(Collectors.toList());
        userEntityList.stream().forEach(s -> s.setNickname("foreach"));
        logger.info("userEntity list changed:" + userEntityList);
        logger.info("map changed: " + userEntityMap);
    }

    /**
     * 赋值时新建对象，保证是值传递，
     * 即修改结果对象时，不影响源对象
     *
     * @param userEntityList 结果对象
     * @param uidList uid列表
     * @param userEntityMap 源对象
     */
    public static void valueCopyTest(List<UserEntity> userEntityList, List<String> uidList, Map<String, UserEntity> userEntityMap) {
        userEntityList = uidList.stream().filter(uid -> null != userEntityMap.get(uid)).map(uid -> {
            UserEntity userEntity = userEntityMap.get(uid);
            return userEntity.copy();
        }).collect(Collectors.toList());
        userEntityList.stream().forEach(s -> s.setNickname("foreach"));
        logger.info("userEntity list changed:" + userEntityList);
        logger.info("map changed: " + userEntityMap);
    }

    public static void main(String[] args) {

        List<UserEntity> userEntityList = new ArrayList<>();
        UserEntity u1 = new UserEntity("u1", "111", "male");
        UserEntity u2 = new UserEntity("u2", "222", "female");
        UserEntity u3 = new UserEntity("u3", "333", "male");
        Map<String, UserEntity> map = new HashMap<>();
        map.put("u1", u1);
        map.put("u2", u2);
        map.put("u3", u3);
        logger.info("map original : " + map);
        List<String> uidList = Stream.of("u1", "u2").collect(Collectors.toList());
        /**
         * 测试时一个一个测
         */
        LambdaDataTransmitTest.referenceTest(userEntityList, uidList, map);
//        LambdaDataTransmitTest.valueTest(userEntityList, uidList, map);
//        LambdaDataTransmitTest.valueCopyTest(userEntityList, uidList, map);
    }
}
