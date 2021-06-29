package datastructure.enum_test;

import java.util.logging.Logger;

/**
 * 枚举测试.
 *
 * @author xindaqi
 * @date 2021-06-29 14:32
 */
public enum ColorEnumTest {

    RED,
    GREEN,
    BLUE
    ;

    private static final Logger logger = Logger.getLogger("EnumOneTest");

    public static void main(String[] args) {
        ColorEnumTest red = ColorEnumTest.RED;
        logger.info("Color from enum: " + red);
    }
}
