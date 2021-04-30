package clzz;

/**
 * 人员信息基类.
 *
 * @author xindaqi
 * @since 2021/4/2 10:02
 */
public class BaseUser {

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户性别
     */
    private String sex;

    public BaseUser() {

    }

    public BaseUser(String username, String address, String sex) {
        this.username = username;
        this.address = address;
        this.sex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "BaseUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
