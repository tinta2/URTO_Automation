package UnityRealTimeOnline.utils;

import UnityRealTimeOnline.constants.EnvType;

import java.util.Properties;

public class ConfigLoader{
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.QA));
        switch (EnvType.valueOf(env)){
            case QA -> properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
            case DEV -> properties = PropertyUtils.propertyLoader("src/test/resources/dev_config.properties");
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            default -> throw new IllegalStateException("INVALIED ENV: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException(("property baseUrl is not specified in the stg_config.properties file"));
    }

}