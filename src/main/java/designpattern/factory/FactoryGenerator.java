package designpattern.factory;

import common.constant.StringConstant;

/**
 * @author xindaqi
 * @description 工厂模式：工厂生成器
 * @since 2021-02-10 23:15:19
 */
public class FactoryGenerator {

    public static AbstractPhoneFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase(StringConstant.CELLPHONE_FACTORY)) {
            return new CellPhoneExtendsFactory();
        }
        return null;
    }

}