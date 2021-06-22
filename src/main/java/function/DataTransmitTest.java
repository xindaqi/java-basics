package function;

import common.entity.UserEntity;

import java.util.logging.Logger;

/**
 * 传递测试-值传递和引用传递.
 *
 * @author xindaqi
 * @date 2021-06-22 17:52
 */
public class DataTransmitTest {

    private static final Logger logger = Logger.getLogger("DataTransmitTest");

    /**
     * 引用传递.
     *
     *  @param source 源对象
     */
    public static void referenceTransmit(UserEntity source) {
        UserEntity target = new UserEntity();
        target = source;
        logger.info("方法内，源对象：" + source);
        logger.info("方法内，结果对象：" + target);
        target.setSex("from_target");
        logger.info("方法内，结果对象修改属性：" + source);
        source.setSex("alien");
        logger.info("方法内，源对象修改属性：" + source);
    }

    /**
     * 值传递.
     *
     *  @param source 源数据
     */
    public static void valueTransmit(int source) {
        int target = source;
        logger.info("方法内，源对象：" + source);
        logger.info("方法内，结果对象：" + target);
        target = 10;
        logger.info("修改结果对象后的源对象数据：" + source);
        source = 10;
    }

    public static void main(String[] args) {
        UserEntity sourceEntity = new UserEntity("1111", "xiaoxiao", "female");
        logger.info("方法外，源对象-1：" + sourceEntity);
        DataTransmitTest.referenceTransmit(sourceEntity);
        logger.info("方法外，源对象-2：" + sourceEntity);
        int sourceInt = 0;
        logger.info("方法外， 源int-1：" + sourceInt);
        DataTransmitTest.valueTransmit(sourceInt);
        logger.info("方法外， 源int-2：" + sourceInt);
    }
}
