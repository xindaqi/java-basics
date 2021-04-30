package algorithm;

import common.constant.IntConstant;

import java.util.logging.Logger;

/**
 * 运算符测试.
 *
 * @author xindaqi
 * @since 2021/4/21 11:53
 */
public class OperationSymbolTest {

    private static final Logger logger = Logger.getLogger("OperationSymbolTest");

    /**
     * 查找数组中的落单数据
     * 数组中只有一个数据出现一次，其他都出现多次
     *
     * @param args 源数组
     * @return 落单的数据
     */
    public int querySingleData(int[] args) {
        int res = IntConstant.ZERO;
        for(int i = 0; i<args.length ; i++) {
            logger.info("异或计算过程结果：" + res + "^" + args[i]);
            res = res ^ args[i];
            logger.info("=" + res);
        }
        return res;
    }
    public static void  main(String[] args) {
        int[] a1 = new int[IntConstant.FIVE];
        a1[0] = 1;
        a1[1] = 1;
        a1[2] = 9;
        a1[3] = 1;
        a1[4] = 1;
        OperationSymbolTest operationSymbolTest = new OperationSymbolTest();
        int v1 = operationSymbolTest.querySingleData(a1);

        logger.info("我是异或计算结果：" + v1);
        int v2 = 0 ^ 1 ^ 1 ^ 2;
        logger.info("异或计算的结果：" + v2);
    }
}
