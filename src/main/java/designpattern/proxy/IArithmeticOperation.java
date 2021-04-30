package designpattern.proxy;

/**
 * @author xindaqi
 * @description 代理模式：算术运算
 * @since 2021-02-15 12:23:01
 */
public interface IArithmeticOperation {

    /**
     * description: 加法
     *
     * @param a: 参数
     * @param b: 参数
     * @return 两数之和
     * @since 2021-02-15 12:26:35
     */
    float addition(float a, float b);

    /**
     * description: 减法
     *
     * @param a: 参数
     * @param b: 参数
     * @return 两数之差
     * @since 2021-02-15 12:27:52
     */
    float substraction(float a, float b);

}