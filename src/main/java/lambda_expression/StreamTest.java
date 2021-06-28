package lambda_expression;

import common.entity.BaseUserEntity;
import common.entity.UserAgeEntity;
import common.entity.UserEntity;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Java stream测试样例.
 *
 * @author xindaqi
 * @date 2021-06-28 17:16
 */
public class StreamTest {

    private static final Logger logger = Logger.getLogger("StreamTest");

    /**
     * 1.List<对象A>通过map转成List<对象B>
     *
     * @param userEntityList     源List对象
     */
    private static void listObjToAnotherListObj(List<UserEntity> userEntityList) {
        List<BaseUserEntity> baseUserEntityList = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().map(e -> new BaseUserEntity(e.getUid(), e.getNickname())).collect(Collectors.toList());
        logger.info("我是转换后的对象：" + baseUserEntityList);
    }

    /**
     * 2.List<对象A>中通过map转成List<String>
     *
     * @param userEntityList 源List对象
     */
    private static void listObjectToList(List<UserEntity> userEntityList) {
        List<String> list = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().map(UserEntity::getUid).collect(Collectors.toList());
        logger.info("我是转换后的list：" + list);
    }

    /**
     * 3.1 List对象通过groupingBy转成Map对象
     *
     * @param userEntityList 源List对象
     */
    private static void listObjectToMapWithGroupingBy(List<UserEntity> userEntityList) {
        Map<String, List<UserEntity>> map = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().collect(Collectors.groupingBy(UserEntity::getUid));
        logger.info("我是grouping by转换后的Map：" + map);
    }

    /**
     * 3.2 List对象通过HashMap::new转成Map对象
     *
     * @param userEntityList 源List对象
     */
    private static void listObjToMapByHashMap(List<UserEntity> userEntityList) {
        Map<String, String> map = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().collect(HashMap::new, (m, v) -> m.put(v.getUid(), v.getNickname()), HashMap::putAll);
        logger.info("我是通过HashMap转换后的Map：" + map);
    }

    /**
     * 3.3 List对象通过toMap转成Map
     *
     * @param userEntityList 源List对象
     */
    private static void listObjToMapByToMap(List<UserEntity> userEntityList) {
        Map<String, String> map = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().collect(Collectors.toMap(UserEntity::getUid, UserEntity::getNickname));
        logger.info("我是通过toMap转换后的Map：" + map);
    }

    /**
     * 4.List对象通过map转成List<Map>
     *
     * @param userEntityList 源List对象
     */
    private static void listObjToListMap(List<UserEntity> userEntityList) {
        List<Map<String, String>> list = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().map((p) -> {
            Map<String, String> map1 = new HashMap<>(2);
            map1.put("nickname", p.getNickname());
            return map1;
        }).collect(Collectors.toList());
        logger.info("我是转换后的List<Map>：" + list);
    }

    /**
     * 5.List对象通过joining转字符串，使用逗号拼接
     *
     * @param list 源List对象
     */
    private static void listToString(List<String> list) {
        String str = Optional.ofNullable(list).orElse(new ArrayList<String>()).stream().collect(Collectors.joining(","));
        logger.info("我是转换后的String：" + str);
    }


    public static void main(String[] args) {

        List<UserEntity> userEntityList = new ArrayList<>();
        Map<String, String> map = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().collect(Collectors.toMap(UserEntity::getUid, UserEntity::getNickname));
        if(map.isEmpty()) {
            logger.info("Arraylist is null or empty");
        } else {
            logger.info("Arraylist is full");
        }
        userEntityList.add(new UserEntity("1", "111", "male"));
        userEntityList.add(new UserEntity("2", "222", "female"));
        userEntityList.add(new UserEntity("3", "333", "male"));

        StreamTest.listObjToAnotherListObj(userEntityList);

        List<UserAgeEntity> userAgeEntityList = new ArrayList<>();
        userAgeEntityList.add(new UserAgeEntity("1", "xiaoxiao", 10));
        userAgeEntityList.add(new UserAgeEntity("2", "xiaohua", 11));
        userAgeEntityList.add(new UserAgeEntity("3", "xiaolan", 12));
        userAgeEntityList.add(new UserAgeEntity("4", "xiaolan", 12));

    }
}
