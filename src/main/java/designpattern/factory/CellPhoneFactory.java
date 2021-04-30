package designpattern.factory;

import common.constant.StringConstant;

/**
 * @author xindaqi
 * @description 工厂模式：CellPhone工厂
 * @since 2021-02-10 22:01:12
 */
public class CellPhoneFactory {

    public ICellPhone getCellPhone(String cellPhoneBrand) {
        if (null == cellPhoneBrand) {
            return null;
        }
        if (cellPhoneBrand.equalsIgnoreCase(StringConstant.APPLE)) {
            return new Apple();
        } else if (cellPhoneBrand.equalsIgnoreCase(StringConstant.SAMSUNG)) {
            return new Samsung();
        }
        return null;
    }

}