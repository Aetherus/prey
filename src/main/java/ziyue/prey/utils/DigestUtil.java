package ziyue.prey.utils;

import org.apache.tomcat.util.security.MD5Encoder;

public class DigestUtil {
    public static String digest(String cleanText) {
        return MD5Encoder.encode(cleanText.getBytes());
    }
}
