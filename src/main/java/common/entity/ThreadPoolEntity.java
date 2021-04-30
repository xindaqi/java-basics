package common.entity;

/**
 * 线程池实体.
 *
 * @author xindaqi
 * @date 2021-04-28 17:59
 */
public class ThreadPoolEntity {

    /**
     * 核心线程数
     */
    private Integer corePoolSize;

    /**
     * 最大线程数
     */
    private Integer maximumPoolSize;

    /**
     * 非核心空闲线程存活时间：毫秒
     */
    private Long keepAliveTime;

    public ThreadPoolEntity(Integer corePoolSize, Integer maximumPoolSize, Long keepAliveTime) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setKeepAliveTime(Long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public Long getKeepAliveTime() {
        return keepAliveTime;
    }
}
