package datastructure;

import common.entity.UserEntity;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * List测试
 *
 * @author xindaqi
 * @since 2021-01-23
 */

public class ListTest {

    private static final Logger logger = Logger.getLogger("ListTest");

    /**
     * List转Map，Map值为基础类型
     *
     * @param params 列表数据
     * @return map 数据集合
     */
    private static Map<String, String> listIteratorToMap(List<UserEntity> params) {
        Map<String, String> map = Optional.ofNullable(params).orElse(new ArrayList<UserEntity>())
                .parallelStream().collect(HashMap::new, (k, v) -> k.put(v.getUid(), v.getNickname()), HashMap::putAll);
        return map;
    }

    /**
     * 普通For循环删除list元素
     *
     * @param list 列表
     */
    private static List<String> removeElementByFor(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("delete")) {
                list.remove(i);
            }
        }
        return list;
    }

    /**
     * 增强For循环删除list元素
     *
     * @param list 列表
     */
    private static List<String> removeElementByForEnhanced(List<String> list) {
        for (String li : list) {
            if (li.equals("delete")) {
                list.remove(li);
            }
        }
        return list;
    }

    /**
     * 迭代方法循环删除list元素
     *
     * @param list 列表
     */
    private static List<String> removeElementByIterator(List<String> list) {
        Iterator<String> li = list.iterator();
        while (li.hasNext()) {
            String e = li.next();
            if (e.equals("delete")) {
                li.remove();
            }
        }
        return list;
    }

    /**
     * List交集
     *
     * @param sourceList 源List
     * @param targetList 目标List
     * @return
     */
    private static List<String> retainAllTest(List<String> sourceList, List<String> targetList) {
        sourceList.retainAll(targetList);
        return sourceList;
    }

    /**
     * null列表测试
     *
     * @param list 列表
     * @return 列表
     */
    private static List<String> nullListTest(List<String> list) {
        return Optional.ofNullable(list).orElse(new ArrayList<>());
    }


    public static void main(String[] args) {
        logger.info("List测试");
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity("1", "xiaoxiao", "male"));
        userEntityList.add(new UserEntity("2", "xiaohua", "female"));
        userEntityList.add(new UserEntity("3", "xiaolan", "male"));
        Map<String, String> map = listIteratorToMap(userEntityList);
        logger.info("list 转 map：" + map);
        List<String> list = Stream.of("delete", "delete", "xiaoxiao", "delete", "xiaoer", "tiantian", "delete", "xiaohua").collect(Collectors.toList());
        logger.info("List removed by iterator: " + removeElementByIterator(list));
//        logger.info("List removed by for: " + removeElementByFor(list));
//        logger.info("List removed by for enhanced: " + removeElementByForEnhanced(list));
        List<String> sourceList = Stream.of("xiaoxiao", "xiaohua", "xiaolan").collect(Collectors.toList());
        List<String> targetList = Stream.of("xiaoxiao", "xiaoer").collect(Collectors.toList());
        logger.info("交集：" + retainAllTest(sourceList, targetList));
        List<String> listNull = null;
        logger.info("列表null返回测试："  + nullListTest(listNull));

    }
}
