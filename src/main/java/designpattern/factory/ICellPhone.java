package designpattern.factory;

/**
 * @author xindaqi
 * @description 工厂模式：CellPhone接口
 * @since 2021-02-10 22:03:14
 */
public interface ICellPhone {
    /**
     * description: 生产手机
     *
     * @return 手机品牌
     * @since 2021-02-10 22:05:34
     */
    String makePhone();
}