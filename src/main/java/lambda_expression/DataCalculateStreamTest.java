package lambda_expression;

import common.entity.UserAgeEntity;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream数据计算测试.
 *
 * @author xindaqi
 * @date 2021-06-29 16:18
 */
public class DataCalculateStreamTest {

    private static final Logger logger = Logger.getLogger("DataCalculateStreamTest");

    /**
     * 1.List<Double>sum求和
     *
     * @param doubleList 源列表
     */
    private static void sumTest(List<Double> doubleList) {
        Double sum = Optional.ofNullable(doubleList).orElse(new ArrayList<>())
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        logger.info("Sum:" + sum);
    }

    /**
     * 2.List<对象>sum求和
     *
     * @param userAgeEntityList 源列表
     */
    private static void sumTestWithObject(List<UserAgeEntity> userAgeEntityList) {
        Integer sum = Optional.ofNullable(userAgeEntityList).orElse(new ArrayList<>())
                .stream()
                .mapToInt(UserAgeEntity::getAge)
                .sum();
        logger.info("Sum:" + sum);
    }

    /**
     * 3.List<Double>average求均值
     *
     * @param doubleList 源列表
     */
    private static void averageTest(List<Double> doubleList) {
        OptionalDouble average = Optional.ofNullable(doubleList).orElse(new ArrayList<>())
                .stream()
                .mapToDouble(Double::doubleValue)
                .average();
        if (average.isPresent()) {
            double averageResult = average.getAsDouble();
            logger.info("Avarege:" + averageResult);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * 4.List<对象>average求均值
     *
     * @param userAgeEntityList 源列表
     */
    private static void averageTestWithObject(List<UserAgeEntity> userAgeEntityList) {
        OptionalDouble average = Optional.ofNullable(userAgeEntityList).orElse(new ArrayList<>())
                .stream()
                .mapToInt(UserAgeEntity::getAge)
                .average();
        if (average.isPresent()) {
            double averageResult = average.getAsDouble();
            logger.info("Average:" + averageResult);
        } else {
            throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {

        List<Double> doubleList = Stream.of(0.2, 0.3).collect(Collectors.toList());
        DataCalculateStreamTest.sumTest(doubleList);
        DataCalculateStreamTest.averageTest(doubleList);

        List<UserAgeEntity> userAgeEntityList = new ArrayList<>();
        userAgeEntityList.add(new UserAgeEntity("1", "xiaoxiao", 10));
        userAgeEntityList.add(new UserAgeEntity("2", "xiaohua", 11));
        userAgeEntityList.add(new UserAgeEntity("3", "xiaolan", 12));
        userAgeEntityList.add(new UserAgeEntity("4", "xiaolan", 12));
        DataCalculateStreamTest.sumTestWithObject(userAgeEntityList);
        DataCalculateStreamTest.averageTestWithObject(userAgeEntityList);
    }
}
