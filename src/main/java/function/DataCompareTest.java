package function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static common.constant.DigitalConstant.ONE;

/**
 * 数据比较.
 *
 * @author xindaqi
 * @date 2021-05-13 9:55
 */
public class DataCompareTest {

    private static final Logger logger = Logger.getLogger("DataCompareTest");

    /**
     * 统计List中字符串出现的次数
     *
     * @param list 源list
     */
    public static Map<String, Long> countDataRepeatInList(List<String> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        logger.info("重复数键值对：" + map);
        return map;
    }

    /**
     * 从统计数量的Map中筛选给定重复次数的键值
     *
     * @param map
     */
    public static void filterRepeatDataInList(Map<String, Long> map, Integer repeatedTimes) {
        Map<String, Long> mapRes = map.entrySet().stream().filter(s -> s.getValue() > repeatedTimes).collect(HashMap::new, (k, v) -> k.put(v.getKey(), v.getValue()), HashMap::putAll);
        logger.info("重复数键值对：" + mapRes);
    }

    public static void main(String[] args) {

        String sourceStr = "123,345,456,123,345,345";
        String[] sourceArr = sourceStr.split(",");
        List<String> list = Arrays.asList(sourceArr);
        Map<String, Long> map = countDataRepeatInList(list);
        filterRepeatDataInList(map, ONE);

    }

}