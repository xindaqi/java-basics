package common.entity;

/**
 * 用户基础信息.
 *
 * @author xindaqi
 * @since 2021/4/15 17:13
 */
public class BaseUserEntity {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 用户昵称
     */
    private String nickname;

    public BaseUserEntity(String uid, String nickname) {
        this.uid = uid;
        this.nickname = nickname;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "BaseUserEntity{" +
                "uid='" + uid + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
