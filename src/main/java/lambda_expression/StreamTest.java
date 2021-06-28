package lambda_expression;

import common.entity.UserAgeEntity;
import common.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Java stream测试样例.
 *
 * @author xindaqi
 * @date 2021-06-28 17:16
 */
public class StreamTest {

    private static final Logger logger = Logger.getLogger("StreamTest");

    public static void main(String[] args) {

        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(new UserEntity("1", "111", "male"));
        userEntityList.add(new UserEntity("2", "222", "female"));
        userEntityList.add(new UserEntity("3", "333", "male"));
        List<UserAgeEntity> userAgeEntityList = new ArrayList<>();
        userAgeEntityList.add(new UserAgeEntity("1", "xiaoxiao", 10));
        userAgeEntityList.add(new UserAgeEntity("2", "xiaohua", 11));
        userAgeEntityList.add(new UserAgeEntity("3", "xiaolan", 12));
        userAgeEntityList.add(new UserAgeEntity("4", "xiaolan", 12));


    }
}
