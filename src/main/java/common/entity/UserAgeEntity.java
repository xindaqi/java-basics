package common.entity;


import common.entity.BaseUserEntity;

/**
 * 我是描述信息.
 *
 * @author xindaqi
 * @since 2021/4/16 9:37
 */
public class UserAgeEntity extends BaseUserEntity {

    /**
     * 用户年龄
     */
    private int age;

    public UserAgeEntity(String uid, String nickname, int age) {
        super(uid, nickname);
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserAgeEntity{" +
                "uid=" + this.getUid() +
                "nickname=" + this.getNickname() +
                "age=" + age +
                '}';
    }
}
