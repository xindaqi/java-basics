package datastructure.abstract_test;

import java.util.List;

/**
 * 抽象类测试.
 *
 * @author xindaqi
 * @date 2021-08-02 17:42
 */
public abstract class AbstractClassTest {

    /**
     * 稀疏数据.
     *
     * @param inputs 输入数据
     */
    abstract List<Double> sparse(List<Double> inputs);

    /**
     * 数据放大.
     *
     * @param rate
     */
    abstract List<Double> expand(List<Double> inputs, Double rate);

    /**
     * 处理数据.
     *
     * @param inputs 输入数据
     * @param rate 方法倍数
     */
    public List<Double> result(List<Double> inputs, Double rate) {
        List<Double> sparseData = sparse(inputs);
        return expand(sparseData, rate);
    }
}
