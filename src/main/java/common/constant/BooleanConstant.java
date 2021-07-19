package common.constant;

/**
 * 布尔常量.
 *
 * @author xindaqi
 * @date 2021-07-19 16:47
 */
public class BooleanConstant {

    /**
     * true
     */
    public static final boolean TRUE = true;

    /**
     * false
     */
    public static final boolean FALSE = false;

    private BooleanConstant() {
        throw new AssertionError(BooleanConstant.class.getName() + StringConstant.PRIVATE_INSTANCE_ERROR);
    }

}
