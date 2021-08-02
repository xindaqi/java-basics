package datastructure.abstract_test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 计算.
 *
 * @author xindaqi
 * @date 2021-08-02 18:31
 */
public class CalculateTest {

    private static final Logger logger = LogManager.getLogger(CalculateTest.class);

    public static void main(String[] args) {
        List<Double> inputs = Stream.of(-0.2, -30.1, 10.6, 0.0, 2.6).collect(Collectors.toList());
        Double rate = 2.0;
        ImageDataProcess imageDataProcess = new ImageDataProcess();
        List<Double> result = imageDataProcess.result(inputs, rate);
        logger.info("Result：{}", result);
    }
}
