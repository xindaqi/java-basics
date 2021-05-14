package database.dto;

/**
 * 输出用户信息.
 *
 * @author xindaqi
 * @date 2021-05-14 16:10
 */
public class UserOutputDTO {

    private String userId;

    private String username;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserInfoOutputDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
