package com.room414.properties.services.impl;

import com.room414.properties.services.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("environmentInitializer")
public class TestServiceImpl implements TestService {

    @Setter(onMethod = @__(@Value("${injectedProperty}")))
    private String injectedProperty;

    @Override
    public String getInjectedProperty() {
        return injectedProperty;
    }

}
