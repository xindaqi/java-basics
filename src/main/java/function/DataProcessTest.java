package function;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static common.constant.DigitalConstant.ONE;
import static common.constant.DigitalConstant.THREE;

/**
 * 数据计算.
 *
 * @author xindaqi
 * @date 2021-05-13 13:44
 */
public class DataProcessTest {

    private static final Logger logger = Logger.getLogger("DataProcessTest");

    /**
     * 替换源列表中数据为指定条件的数据
     *
     * @param sourceList 源数据列表
     * @param maxCondition 替换的数据
     * @return 替换数据后的列表
     */
    private static List<Integer> setMaxWithCondition(List<Integer> sourceList, int maxCondition) {
        List<Integer> listRes = new ArrayList<>();
        Optional.ofNullable(sourceList).orElse(new ArrayList<>())
                .stream()
                .forEach(s -> {
                    if(s > maxCondition) {
                        listRes.add(maxCondition);
                    } else {
                        listRes.add(s);
                    }
                });
        return listRes;
    }

    /**
     * 数据转换
     *
     * @param list 源list
     */
    private static void dataTransform(List<Integer> list) {
        List<Integer> listRes = new ArrayList<>();
        list.stream().forEach(e ->{
            if(e > ONE) {
                listRes.add(ONE);
            } else {
                listRes.add(e);
            }
        });
        logger.info("方法内处理的list：" + listRes);
    }

    public static void main(String[] args) {

        BigDecimal num1 = new BigDecimal("0.01");
        BigDecimal num2 = new BigDecimal("0.003");
        BigDecimal num3 = new BigDecimal("4.8929183");

        logger.info("BigDecimal加法：" + num1.add(num2));
        logger.info("BigDecimal减法：" + num1.subtract(num2));
        logger.info("BigDecimal乘法：" + num2.multiply(num3));
        logger.info("BigDecimal除法：" + num3.divide(num2, THREE, BigDecimal.ROUND_HALF_UP));

        double a = 10.123456789012345678;
        logger.info("双精度数据：" + a);
        float b = 111111.12345678f;
        logger.info("单精度数据：" + b);
        List<Integer> list = Stream.of(1, 2, 0, 4).collect(Collectors.toList());
        dataTransform(list);
        logger.info("我是处理后的list：" + list);
        List<Integer> setList = setMaxWithCondition(list, ONE);
        logger.info("设置最大值后的数据：" + setList);
    }
}