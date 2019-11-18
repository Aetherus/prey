package ziyue.prey.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class DigestUtil {
    public static String digest(String cleanText) {
        return DigestUtils.appendMd5DigestAsHex(cleanText.getBytes(StandardCharsets.UTF_8), new StringBuilder()).toString();
    }
}
