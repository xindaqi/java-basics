package designpattern.observer;

/**
 * @author xindaqi
 * @description 观察者模式：主题
 * @since 2021-02-12 12:31:52
 */
public interface ISubject {

    /**
     * description: 订阅
     *
     * @param observer 观察者
     * @return
     * @since 2021-02-12 12:32:37
     */
    void subscribe(IObserver observer);

    /**
     * description: 取消订阅
     *
     * @param observer 观察者
     * @return
     * @since 2021-02-12 12:33:20
     */
    void unsubscribe(IObserver observer);

    /**
     * description: 通知变更
     *
     * @param
     * @return
     * @since 2021-02-12 12:35:02
     */
    void notifyChanged();

}