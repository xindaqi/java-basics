package designpattern.adapter;

import common.constant.IntConstant;

/**
 * @author xindaqi
 * @description 适配器模式：220V设备
 * @since 2021-02-11 07:58:51
 */
public class TwoHundredTwentyVoltageDevice implements IPowerSupplyAdapter {

    @Override
    public int twoHundredTwentyVoltage() {
        return IntConstant.TWOHUNDREDTWENTY;
    }

}