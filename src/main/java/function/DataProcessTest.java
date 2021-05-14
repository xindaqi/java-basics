package function;

import java.math.BigDecimal;
import java.util.logging.Logger;

import static common.constant.DigitalConstant.THREE;

/**
 * 数据计算.
 *
 * @author xindaqi
 * @date 2021-05-13 13:44
 */
public class DataProcessTest {

    private static final Logger logger = Logger.getLogger("DataProcessTest");

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
    }
}