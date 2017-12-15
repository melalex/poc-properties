package com.room414.properties.init;

import com.room414.properties.services.PropertiesService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@DependsOn("dataSourceInitializer")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EnvironmentInitializer {
    private static final String PROPERTY_SOURCE_NAME = "repository";

    @Setter(onMethod = @__(@Autowired))
    private PropertiesService propertiesRepository;

    @Setter(onMethod = @__(@Autowired))
    private ConfigurableEnvironment environment;

    @PostConstruct
    public void init() {
        environment.getPropertySources()
                .addLast(new RepositoryPropertySource(PROPERTY_SOURCE_NAME, propertiesRepository));
        log.info("Registered custom PropertySource");
    }

    private static class RepositoryPropertySource extends PropertySource<PropertiesService> {

        RepositoryPropertySource(String name, PropertiesService source) {
            super(name, source);
        }

        @Override
        public Object getProperty(String name) {
            return source.getProperty(name);
        }
    }
}

