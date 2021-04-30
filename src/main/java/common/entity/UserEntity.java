package common.entity;

/**
 * User实体
 *
 * @author xindaqi
 * @since 2021-01-23
 */

public class UserEntity {
    private String uid;

    private String nickname;

    private String sex;

    public UserEntity() {
    }

    public UserEntity(String uid, String nickname, String sex) {
        this.uid = uid;
        this.nickname = nickname;
        this.sex = sex;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
