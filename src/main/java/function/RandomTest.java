package function;

import common.constant.DigitalConstant;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * 生成随机数测试.
 *
 * @author xindaqi
 * @date 2021-06-10 14:09
 */
public class RandomTest {

    private static Logger logger = Logger.getLogger("RandomTest");

    /**
     * 生成指定位数的随机数
     *
     * @param scale 小数点后有效位个数
     * @return 指定有效位的随机数
     */
    public double randomGenerator(int scale) {
        return new BigDecimal(Math.random()).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        double random = Math.random();
        logger.info("随机数：" + random);
        RandomTest randomTest = new RandomTest();
        double randomScale = randomTest.randomGenerator(DigitalConstant.THREE);
        logger.info("指定位数的随机数：" + randomScale);

    }
}
