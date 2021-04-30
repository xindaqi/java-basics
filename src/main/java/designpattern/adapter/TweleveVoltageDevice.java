package designpattern.adapter;

import common.constant.IntConstant;

/**
 * @author xindaqi
 * @description 适配器模式：12V设备
 * @since 2021-02-11 07:56:16
 */
public class TweleveVoltageDevice implements IPowerSupplyAdapter {

    @Override
    public int tweleveVoltage() {
        return IntConstant.TWELEVE;
    }

}