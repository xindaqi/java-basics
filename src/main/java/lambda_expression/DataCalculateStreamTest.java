package lambda_expression;

import common.entity.UserAgeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public static void main(String[] args) {

        List<Double> doubleList = Stream.of(0.2, 0.3).collect(Collectors.toList());
        DataCalculateStreamTest.sumTest(doubleList);

        List<UserAgeEntity> userAgeEntityList = new ArrayList<>();
        userAgeEntityList.add(new UserAgeEntity("1", "xiaoxiao", 10));
        userAgeEntityList.add(new UserAgeEntity("2", "xiaohua", 11));
        userAgeEntityList.add(new UserAgeEntity("3", "xiaolan", 12));
        userAgeEntityList.add(new UserAgeEntity("4", "xiaolan", 12));
        DataCalculateStreamTest.sumTestWithObject(userAgeEntityList);
    }
}
