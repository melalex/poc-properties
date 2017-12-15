package com.room414.properties.services.impl;

import com.room414.properties.domain.Property;
import com.room414.properties.repositories.PropertiesRepository;
import com.room414.properties.services.PropertiesService;
import com.room414.properties.services.internal.ProfileManager;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PropertiesServiceImpl implements PropertiesService {

    @Setter(onMethod = @__(@Autowired))
    private PropertiesRepository propertiesRepository;

    @Setter(onMethod = @__(@Autowired))
    private ProfileManager profileManager;

    @Override
    public Map<String, Object> getEnvironment() {
        return StreamSupport.stream(propertiesRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(Property::getKey, Property::getValue));
    }

    @Override
    public String getProperty(String key) {
        return Optional.ofNullable(propertiesRepository.findOne(key))
                .map(Property::getValue)
                .orElse(null);
    }

    @Override
    public String getProperty(String profile, String key) {
        return getProperty(profileManager.getProfiledKey(profile, key));
    }

    @Override
    public void setProperty(String key, String value) {
        propertiesRepository.setPropertyByKey(key, value);
    }

    @Override
    public void setProperty(String profile, String key, String value) {
        setProperty(profileManager.getProfiledKey(profile, key), value);
    }
}
