package org.selenium.pom.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static <T> T deserializeJson(String fileName , Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readValue(is,T);

    }
}
