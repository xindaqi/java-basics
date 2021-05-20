package datastructure;

import java.util.logging.Logger;

import static common.constant.DigitalConstant.*;

/**
 * enum测试.
 *
 * @author xindaqi
 * @date 2021-05-11 14:26
 */
public enum EnumTest {

    HEILONGJIANG("黑龙江省", ZERO),
    ANHUI("安徽省", ONE),
    LIAONING("辽宁省", TWO),
    GUANGDONG("广东省", THREE),
    ;

    /**
     * 省名称
     */
    private String provicneName;

    /**
     * 省编号
     */
    private Integer number;

    EnumTest(String provinceName, Integer number) {
        this.provicneName = provinceName;
        this.number = number;
    }

    public void judgeObject() {
        if(this == EnumTest.ANHUI) {
            logger.info("使用了ANHUI");
        } else {
            logger.info("使用其他枚举值");
        }
    }

    public String getProvicneName() {
        return provicneName;
    }

    public Integer getNumber() {
        return number;
    }

    private static final Logger logger = Logger.getLogger("EnumTest");

    public static void main(String[] args) {

        EnumTest enumTest = EnumTest.ANHUI;
        enumTest.judgeObject();
        logger.info("Province: " + enumTest.getProvicneName() + ",number:" + enumTest.getNumber());
    }
}