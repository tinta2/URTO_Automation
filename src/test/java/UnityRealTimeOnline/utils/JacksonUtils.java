package UnityRealTimeOnline.utils;

import UnityRealTimeOnline.objects.LabInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
    public static LabInformation deserializeJson(InputStream is, LabInformation labInformation) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, labInformation.getClass());
    }
}
