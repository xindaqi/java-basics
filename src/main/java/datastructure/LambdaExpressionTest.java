package datastructure;

import common.entity.BaseUserEntity;
import common.entity.UserAgeEntity;
import common.entity.UserEntity;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8 Lambda表达式测试.
 *
 * @author xindaqi
 * @since 2021/4/15 16:51
 */
public class LambdaExpressionTest {

    private static final Logger logger = Logger.getLogger("LambdaExpressionTest");

    /**
     * List对象转List对象
     *
     * @param userEntityList     源List对象
     * @param baseUserEntityList 目标List对象
     */
    void listObjToAnotherListObj(List<UserEntity> userEntityList, List<BaseUserEntity> baseUserEntityList) {
        baseUserEntityList = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().map(e -> new BaseUserEntity(e.getUid(), e.getNickname())).collect(Collectors.toList());
        logger.info("我是转换后的对象：" + baseUserEntityList);
    }

    /**
     * List对象中获取某个字段组成List
     *
     * @param userEntityList 源List对象
     * @param list           目标List对象
     */
    void listObjectToList(List<UserEntity> userEntityList, List<String> list) {
        list = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().map(UserEntity::getUid).collect(Collectors.toList());
        logger.info("我是转换后的list：" + list);
    }

    /**
     * List对象分组转Map对象
     *
     * @param userEntityList 源List对象
     * @param map            目标Map对象
     */
    void listObjectToMapWithGroupingBy(List<UserEntity> userEntityList, Map<String, List<UserEntity>> map) {
        map = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().collect(Collectors.groupingBy(UserEntity::getUid));
        logger.info("我是grouping by转换后的Map：" + map);
    }

    /**
     * List对象转Map对象
     *
     * @param userEntityList 源List对象
     * @param map            目标Map对象
     */
    void listObjToMapByHashMap(List<UserEntity> userEntityList, Map<String, String> map) {
        map = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().collect(HashMap::new, (m, v) -> m.put(v.getUid(), v.getNickname()), HashMap::putAll);
        logger.info("我是通过HashMap转换后的Map：" + map);
    }

    /**
     * List对象通过toMap转Map对象
     *
     * @param userEntityList 源List对象
     * @param map            目标Map对象
     */
    void listObjToMapByToMap(List<UserEntity> userEntityList, Map<String, String> map) {
        map = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().collect(Collectors.toMap(UserEntity::getUid, UserEntity::getNickname));
        logger.info("我是通过toMap转换后的Map：" + map);
    }

    /**
     * List对象转换为Map<String, Object>对象
     *
     * @param userEntityList 源List对象
     * @param map            目标Map对象
     */
    void listObjectToMapObj(List<UserEntity> userEntityList, Map<String, UserEntity> map) {
        map = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().collect(Collectors.toMap(UserEntity::getUid, obj -> obj));
        logger.info("我是转换后的Map<String, Object>对象：" + map);
    }

    /**
     * List对象转List<Map>对象
     *
     * @param userEntityList 源List对象
     * @param list           目标List对象
     */
    void listObjToListMap(List<UserEntity> userEntityList, List<Map<String, String>> list) {
        list = Optional.ofNullable(userEntityList).orElse(new ArrayList<>()).stream().map((p) -> {
            Map<String, String> map1 = new HashMap<>(2);
            map1.put("nickname", p.getNickname());
            return map1;
        }).collect(Collectors.toList());
        logger.info("我是转换后的List<Map>：" + list);
    }

    /**
     * List对象转字符串，使用逗号拼接
     *
     * @param list 源List对象
     * @param str  目标String
     */
    void listToString(List<String> list, String str) {
        str = Optional.ofNullable(list).orElse(new ArrayList<String>()).stream().collect(Collectors.joining(","));
        logger.info("我是转换后的String：" + str);
    }

    /**
     * 通过toCollection将List对象转换为List<String>
     *
     * @param userEntityList
     * @param list
     */
    void listObjToListString(List<UserEntity> userEntityList, List<String> list) {
        list = Optional.ofNullable(userEntityList).orElse(new ArrayList<UserEntity>()).stream().map(UserEntity::getNickname).collect(Collectors.toCollection(ArrayList::new));
        logger.info("我是toCollection转换的List<String>：" + list);
    }

    /**
     * List<Integer>求和
     *
     * @param list 源List对象
     */
    void listIntegerSum(List<Integer> list) {
        Integer sum = Optional.ofNullable(list).orElse(new ArrayList<Integer>()).stream().reduce(Integer::sum).orElse(0);
        logger.info("我是reduce sum求和结果：" + sum);
    }

    /**
     * List<Object>求和
     *
     * @param userAgeEntityList 源List对象
     */
    void listObjSum(List<UserAgeEntity> userAgeEntityList) {
        Integer sum = Optional.ofNullable(userAgeEntityList).orElse(new ArrayList<UserAgeEntity>()).stream().mapToInt(UserAgeEntity::getAge).sum();
        logger.info("我是List<Object>求和结果：" + sum);
    }


    public static void main(String[] args) {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity("1", "xiaoxiao", "male"));
        userEntityList.add(new UserEntity("2", "xiaohua", "female"));
        userEntityList.add(new UserEntity("3", "xiaolan", "male"));
        List<UserAgeEntity> userAgeEntityList = new ArrayList<>();
        userAgeEntityList.add(new UserAgeEntity("1", "xiaoxiao", 10));
        userAgeEntityList.add(new UserAgeEntity("2", "xiaohua", 11));
        userAgeEntityList.add(new UserAgeEntity("3", "xiaolan", 12));
        List<BaseUserEntity> baseUserEntityList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Map<String, List<UserEntity>> map = new HashMap<>(2);
        Map<String, String> map1 = new HashMap<>(2);
        Map<String, UserEntity> map2 = new HashMap<>(2);
        List<Map<String, String>> list1 = new ArrayList<>();
        List<String> list2 = Stream.of("xiaoxiao", "xiaohua", "lantian").collect(Collectors.toList());
        List<Integer> list3 = Stream.of(1, 3, 5, 7).collect(Collectors.toList());
        String str = null;
        LambdaExpressionTest lambdaExpressionTest = new LambdaExpressionTest();

        /**
         * List对象转List对象
         */
        lambdaExpressionTest.listObjToAnotherListObj(userEntityList, baseUserEntityList);
        lambdaExpressionTest.listObjectToList(userEntityList, list);
        lambdaExpressionTest.listObjectToMapWithGroupingBy(userEntityList, map);
        lambdaExpressionTest.listObjToMapByHashMap(userEntityList, map1);
        lambdaExpressionTest.listObjToListMap(userEntityList, list1);
        lambdaExpressionTest.listObjToMapByToMap(userEntityList, map1);
        lambdaExpressionTest.listObjectToMapObj(userEntityList, map2);
        lambdaExpressionTest.listToString(list2, str);
        lambdaExpressionTest.listObjToListString(userEntityList, list);
        lambdaExpressionTest.listIntegerSum(list3);
        lambdaExpressionTest.listObjSum(userAgeEntityList);
    }


}
