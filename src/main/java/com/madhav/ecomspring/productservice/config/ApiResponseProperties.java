package com.madhav.ecomspring.productservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "api.response")
public class ApiResponseProperties {
    private List<String> excludedPaths;
}
