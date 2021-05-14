package common.entity;

/**
 * 我是描述信息.
 *
 * @author xindaqi
 * @date 2021-05-13 11:40
 */
public class StringRepeatedTimesEntity extends BaseDataRepeatedTimesEntity {

    /**
     * 重复的数据
     */
    private String data;

    public StringRepeatedTimesEntity(String data, Long repeatedTimes) {
        super(repeatedTimes);
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "StringRepeatedTimesEntity{" +
                "data='" + data + '\'' +
                "} " + super.toString();
    }
}