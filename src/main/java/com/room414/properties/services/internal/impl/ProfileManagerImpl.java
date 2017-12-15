package com.room414.properties.services.internal.impl;

import com.google.common.collect.ImmutableMap;
import com.room414.properties.services.internal.ProfileManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class ProfileManagerImpl implements ProfileManager {
    private Map<String, String> profileToPrefixMap;

    @PostConstruct
    public void init() {
        profileToPrefixMap = ImmutableMap.<String, String>builder()
                .put("profile1", "profile1.")
                .put("profile2", "profile2.")
                .build();
    }

    @Override
    public String getProfiledKey(String profile, String key) {
        return profileToPrefixMap.get(profile) + key;
    }
}
