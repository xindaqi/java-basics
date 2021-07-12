package thirdparty;

import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import common.entity.UserFromProto;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static common.constant.DigitalConstant.SIX;

/**
 * Google protobuf测试.
 *
 * @author xindaqi
 * @date 2021-05-08 11:00
 */
public class GoogleProtoTest {

    private static final Logger logger = Logger.getLogger("GoogleProtoTest");

    /**
     * 通过Google protobuf创建类
     *
     * @return 对象字节数组
     * @throws InvalidProtocolBufferException
     */
    public static byte[] createObjectFromProto() throws InvalidProtocolBufferException {
        UserFromProto.User.Builder userBuilder = UserFromProto.User.newBuilder();
        userBuilder.setAge(SIX)
                .setUsername("xiaoxiao")
                .setSex("male");
        List<UserFromProto.User.Team> teamList = new ArrayList<>();
        UserFromProto.User.Team.Builder team = UserFromProto.User.Team.newBuilder();
        team.setCeo("ceo");
        team.setCfo("cfo");
        UserFromProto.User.Team.Builder team1 = UserFromProto.User.Team.newBuilder();
        team1.setCeo("ceo2");
        team1.setCfo("cfo2");
        userBuilder.addTeamList(team);
        userBuilder.addTeamList(team1);

        teamList.add(team.build());
        teamList.add(team1.build());
        userBuilder.addAllTeamList(teamList);
        logger.info("Proto创建的类：" + userBuilder);
        Gson json = new Gson();
        logger.info("gson:" + json.toJson(userBuilder));
        return userBuilder.build().toByteArray();
    }

    /**
     * 解析字节数组，转换为对象
     *
     * @param params 字节数组
     * @throws InvalidProtocolBufferException
     */
    public static void parseObjectFromProto(byte[] params) throws InvalidProtocolBufferException {
        logger.info("入参：" + params);
        UserFromProto.User user = UserFromProto.User.parseFrom(params);
        logger.info("Proto解析字节结果：" + user);
        logger.info("username: " + user.getUsername());
        logger.info("cto:" + user.getTeam().getCto());
        List<UserFromProto.User.Team> teamList = user.getTeamListList();
        logger.info("team list:" + teamList);
    }



    public static void main(String[] args) {
        try {
            byte[] params = createObjectFromProto();
            parseObjectFromProto(params);

        } catch(InvalidProtocolBufferException ipe) {
            throw new RuntimeException(ipe);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

}
