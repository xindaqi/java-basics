package security;

import java.util.logging.Logger;
import static com.alibaba.druid.util.Utils.md5;

/**
 * MD5测试.
 *
 * @author xindaqi
 * @date 2021-05-06 14:06
 */
public class Md5Test {

    private static final Logger logger = Logger.getLogger("Md5Test");

    public static void main(String[] args) {
        String imei = "1243rjadakdjf";
        String md5Imei = md5(imei.toLowerCase());
        logger.info("MD5: " + md5Imei);
    }

}