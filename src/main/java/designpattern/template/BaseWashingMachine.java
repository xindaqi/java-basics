package designpattern.template;

/**
 * @author xindaqi
 * @description 模板模式：洗衣机
 * @since 2021-02-12 14:54:45
 */
public abstract class BaseWashingMachine {

    /**
     * description: 开机
     *
     * @param
     * @return
     * @since 2021-02-12 15:06:26
     */
    abstract void powerOn();

    /**
     * description: 运行
     *
     * @param
     * @return
     * @since 2021-02-12 15:06:42
     */
    abstract void work();

    /**
     * description: 关机
     *
     * @param
     * @return
     * @since 2021-02-12 15:06:57
     */
    abstract void powerOff();

    /**
     * description: 模板
     *
     * @param
     * @return
     * @since 2021-02-12 15:07:16
     */
    public void operation() {
        powerOn();
        work();
        powerOff();
    }

}