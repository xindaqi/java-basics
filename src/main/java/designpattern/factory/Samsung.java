package designpattern.factory;

import common.constant.StringConstant;

/**
 * @author xindaqi
 * @description SAMSUNG手机
 * @since 2021-02-10 22:20:24
 */
public class Samsung implements ICellPhone {

    @Override
    public String makePhone() {
        return StringConstant.SAMSUNG;
    }

}