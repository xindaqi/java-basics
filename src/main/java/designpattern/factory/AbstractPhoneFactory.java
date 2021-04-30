package designpattern.factory;

/**
 * @author xindaqi
 * @description 工厂模式：抽象工厂
 * @since 2021-02-10 23:01:23
 */
public abstract class AbstractPhoneFactory {

    /**
     * description: 获取手机工厂
     *
     * @param cellPhoneBrand 手机品牌
     * @return 手机工厂接口
     * @since 2021-02-10 23:02:40
     */
    public abstract ICellPhone getCellPhone(String cellPhoneBrand);

}