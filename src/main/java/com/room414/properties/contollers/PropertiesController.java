package com.room414.properties.contollers;

import com.room414.properties.services.PropertiesService;
import com.room414.properties.services.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/properties")
public class PropertiesController {

    @Setter(onMethod = @__(@Autowired))
    private PropertiesService propertiesService;

    @Setter(onMethod = @__(@Autowired))
    private TestService testService;

    @GetMapping("/injected")
    public String getInjectedProperty() {
        return testService.getInjectedProperty();
    }

    @GetMapping
    public Map<String, Object> getEnvironment() {
        return propertiesService.getEnvironment();
    }

    @GetMapping("/{key}")
    public String getProperty(@PathVariable("key") String key) {
        return propertiesService.getProperty(key);
    }

    @GetMapping("/{profile}/{key}")
    public String getProperty(@PathVariable("profile") String profile, @PathVariable("key") String key) {
        return propertiesService.getProperty(profile, key);
    }

    @PutMapping("/{key}")
    public void setProperty(@PathVariable("key") String key, String value) {
        propertiesService.setProperty(key, value);
    }

    @PutMapping("/{profile}/{key}")
    public void setProperty(@PathVariable("profile") String profile, @PathVariable("key") String key, String value) {
        propertiesService.setProperty(profile, key, value);
    }
}
