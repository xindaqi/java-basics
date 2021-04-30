package clzz;

import java.util.List;

/**
 * 工程师用户.
 *
 * @author xindaqi
 * @since 2021/4/2 10:07
 */
public class EngineerUser extends BaseUser {

    /**
     * 开发语言列表
     */
    private List<String> developLanguage;

    /**
     * 技术等级
     */
    private String technologyLevel;

    /**
     * 开发年限
     */
    private int developAge;

    public EngineerUser() {

    }

    public EngineerUser(String username, String address, String sex, List<String> developLanguage, String technologyLevel, int developAge) {
        super(username, address, sex);
        this.developLanguage = developLanguage;
        this.technologyLevel = technologyLevel;
        this.developAge = developAge;
    }

    public void setDevelopLanguage(List<String> developLanguage) {
        this.developLanguage = developLanguage;
    }

    public List<String> getDevelopLanguage() {
        return developLanguage;
    }

    public void setTechnologyLevel(String technologyLevel) {
        this.technologyLevel = technologyLevel;
    }

    public String getTechnologyLevel() {
        return technologyLevel;
    }

    public void setDevelopAge(int developAge) {
        this.developAge = developAge;
    }

    public int getDevelopAge() {
        return developAge;
    }

    @Override
    public String toString() {
        return "EngineerUser{" +
                "username=" + this.getUsername() +
                ", address=" + this.getAddress() +
                ", sex=" + this.getSex() +
                ", developLanguage=" + developLanguage +
                ", technologyLevel='" + technologyLevel + '\'' +
                ", developAge=" + developAge +
                '}';
    }
}
