package designpattern.adapter;

/**
 * @author xindaqi
 * @description 适配器模式：电源
 * @since 2021-02-11 06:59:16
 */
public interface IPowerSupply {

    /**
     * description: 电压
     *
     * @param deviceType 设备类型
     * @return 电压
     * @since 2021-02-11 07:01:03
     */
    int voltage(String deviceType);

}