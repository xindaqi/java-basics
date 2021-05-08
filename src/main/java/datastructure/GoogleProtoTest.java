package datastructure;

import com.google.protobuf.InvalidProtocolBufferException;
import common.entity.UserFromProto;

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
        logger.info("Proto创建的类：" + userBuilder);
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
