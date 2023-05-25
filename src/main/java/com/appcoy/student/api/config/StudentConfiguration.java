package com.appcoy.student.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
    @Value("${sample.configuration.text}")
    public String sampleConfigurationText;

    @Value("${sample.configuration.number}")
    public Integer sampleConfigurationNumber;

//    @Bean
//    @Scope("prototype")
//    public UserDto getUserDto() {
//        return new UserDto("Emmanuel");
//    }
}
