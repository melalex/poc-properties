package com.room414.properties.services;

import java.util.Map;

public interface PropertiesService {

    Map<String, Object> getEnvironment();

    String getProperty(String key);

    String getProperty(String profile, String key);

    void setProperty(String key, String value);

    void setProperty(String profile, String key, String value);
}
