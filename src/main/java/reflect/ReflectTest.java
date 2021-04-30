package reflect;

import common.entity.UserEntity;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * 反射测试.
 *
 * @author xindaqi
 * @since 2021/4/16 10:26
 */
public class ReflectTest {

    private static final Logger logger = Logger.getLogger("ReflectTest");

    /**
     * 反射获取声明的方法，并调用
     *
     * @param clzz 类
     */
    void reflectMethodTest(Class<?> clzz) {
        String className = clzz.getName();
        String typeName = clzz.getTypeName();
        String simpleName = clzz.getSimpleName();
        try {
            Object obj = clzz.newInstance();
            Method[] methods = clzz.getDeclaredMethods();
            for (Method method : methods) {
                logger.info("通过反射获取声明的方法名称：" + method.getName());
            }
            Method method = clzz.getDeclaredMethod("setUid", String.class);
            method.invoke(obj, "1234");
            Method getUidMethod = clzz.getMethod("getUid");
            String uid = getUidMethod.invoke(obj).toString();
            logger.info("我是反射获取的uid：" + uid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        logger.info("类名称：" + className + ",类型名称：" + typeName + ",Simple名称：" + simpleName);
    }

    /**
     * 反射设置属性与获取属性值
     *
     * @param clzz 类
     */
    void reflectField(Class<?> clzz) {
        try {
            Object obj = clzz.newInstance();
            Field[] fields = clzz.getDeclaredFields();
            for (Field field : fields) {
                logger.info("通过反射获取声明的属性名：" + field.getName());
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clzz);
                Method method = pd.getWriteMethod();
                if (field.getType() == String.class) {
                    method.invoke(obj, "xiaoxiao");
                }
                if (field.getType() == Integer.class) {
                    method.invoke(obj, 123);
                }
            }
            for (Field field : fields) {
                PropertyDescriptor pd1 = new PropertyDescriptor(field.getName(), clzz);
                Method method1 = pd1.getReadMethod();
                logger.info("我是反射获取的属性值：" + method1.invoke(obj));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity();
        ReflectTest reflectTest = new ReflectTest();
        reflectTest.reflectMethodTest(UserEntity.class);
        reflectTest.reflectField(UserEntity.class);

    }
}
