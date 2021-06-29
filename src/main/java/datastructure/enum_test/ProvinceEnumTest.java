package datastructure.enum_test;

import common.constant.StringConstant;

import java.util.logging.Logger;

import static common.constant.DigitalConstant.*;

/**
 * enum测试.
 *
 * @author xindaqi
 * @date 2021-05-11 14:26
 */
public enum ProvinceEnumTest {

    HEILONGJIANG("黑龙江省", ZERO),
    ANHUI("安徽省", ONE),
    LIAONING("辽宁省", TWO),
    GUANGDONG("广东省", THREE),
    ;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 省编号
     */
    private Integer number;

    ProvinceEnumTest(String provinceName, Integer number) {
        this.provinceName = provinceName;
        this.number = number;
    }

    /**
     * 通过if获取provinceName和对应的number
     */
    public void judgeObject() {
        if (this == ProvinceEnumTest.ANHUI) {
            logger.info("使用了ANHUI");
        } else {
            logger.info("使用其他枚举值");
        }
    }

    /**
     * 通过switch获取provinceName
     *
     * @return
     */
    public String judgeProvinceName() {
        switch (this) {
            case ANHUI:
                return ANHUI.getProvinceName();
            case HEILONGJIANG:
                return HEILONGJIANG.getProvinceName();
            case GUANGDONG:
                return GUANGDONG.getProvinceName();
            default:
                return StringConstant.EMPTY;
        }
    }

    public String getProvinceName() {
        return provinceName;
    }

    public Integer getNumber() {
        return number;
    }

    private static final Logger logger = Logger.getLogger("EnumTest");

    public static void main(String[] args) {

        ProvinceEnumTest anhui = ProvinceEnumTest.ANHUI;
        anhui.judgeObject();
        logger.info("Province: " + anhui.getProvinceName() + ",number:" + anhui.getNumber());

        String provinceName = anhui.judgeProvinceName();
        logger.info("Province name:" + provinceName);

    }
}