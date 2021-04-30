package designpattern.decorator;

import java.util.logging.Logger;

/**
 * @author xindaqi
 * @description 装饰器模式：测试用例
 * @since 2021-02-11 19:42:18
 */

public class DecoratorTest {

    private static final Logger logger = Logger.getLogger("DecoratorTest");

    public static void main(String[] args) {
        ICellPhone apple = new Apple();
        logger.info("手机：" + apple.makePhone());
        ICellPhone samsung = new Samsung();
        logger.info("手机：" + samsung.makePhone());
        CellPhoneDecorator cellPhoneDecorator = new AdapterCellPhoneDecorator(new Apple());
        logger.info("手机：" + cellPhoneDecorator.makePhone());
    }

}