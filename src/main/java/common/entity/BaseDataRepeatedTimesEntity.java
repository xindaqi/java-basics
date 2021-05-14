package common.entity;

/**
 * 数据重复基础实体.
 *
 * @author xindaqi
 * @date 2021-05-13 11:35
 */
public class BaseDataRepeatedTimesEntity {

    /**
     * 数据重复次数
     */
    private Long repeatedTimes;

    public BaseDataRepeatedTimesEntity(Long repeatedTimes) {
        this.repeatedTimes = repeatedTimes;
    }

    public void setRepeatedTimes(Long repeatedTimes) {
        this.repeatedTimes = repeatedTimes;
    }

    public Long getRepeatedTimes() {
        return repeatedTimes;
    }

    @Override
    public String toString() {
        return "DataRepeatedTimes{" +
                "repeatedTimes=" + repeatedTimes +
                '}';
    }
}