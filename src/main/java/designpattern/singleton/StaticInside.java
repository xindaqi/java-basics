package designpattern.singleton;

/**
 * @author xindaqi
 * @description 单例模式：静态内部类
 * @since 2021-02-10 20:02:51
 */
public class StaticInside {

    private static class StaticInsideHandler {
        private static final StaticInside INSTANCE = new StaticInside();
    }

    private StaticInside() {
    }

    public static final StaticInside getInstance() {
        return StaticInsideHandler.INSTANCE;
    }

}