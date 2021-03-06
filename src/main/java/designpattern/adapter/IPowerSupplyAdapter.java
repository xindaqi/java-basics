package designpattern.adapter;

/**
 * @author xindaqi
 * @description 是脾气模式：电源适配器
 * @since 2021-02-11 07:02:17
 */
public interface IPowerSupplyAdapter {

    /**
     * description: 5V电源
     *
     * @param
     * @return 5V电压
     * @since 2021-02-11 07:35:33
     */
    default int fiveVoltage() {
        return 0;
    }

    /**
     * description: 12V电源
     *
     * @param
     * @return 12V电压
     * @since 2021-02-11 07:35:33
     */
    default int tweleveVoltage() {
        return 0;
    }

    /**
     * description: 220V电源
     *
     * @param
     * @return 220V电压
     * @since 2021-02-11 07:35:33
     */
    default int twoHundredTwentyVoltage() {
        return 0;
    }

}