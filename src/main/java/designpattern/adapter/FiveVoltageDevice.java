package designpattern.adapter;

import common.constant.IntConstant;

/**
 * @author xindaqi
 * @description 适配器模式：5V设备
 * @since 2021-02-11 07:44:23
 */
public class FiveVoltageDevice implements IPowerSupplyAdapter {

    @Override
    public int fiveVoltage() {
        return IntConstant.FIVE;
    }

}