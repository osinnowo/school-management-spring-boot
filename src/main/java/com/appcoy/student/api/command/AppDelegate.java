package com.appcoy.student.api.command;

import com.appcoy.student.api.config.StudentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppDelegate implements CommandLineRunner {

    @Autowired
    private StudentConfiguration configuration;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppDelegate Started");
        System.out.println(String.format("Configuration Text => %s", configuration.sampleConfigurationText));
        System.out.println(String.format("Configuration Number => %d", configuration.sampleConfigurationNumber));
        //System.out.println(String.format("DTO Name => %s", configuration.getUserDto().getFirstName()));
    }
}
