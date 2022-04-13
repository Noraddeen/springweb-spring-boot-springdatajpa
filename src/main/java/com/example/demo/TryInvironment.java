package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootConfiguration
@PropertySource("classpath:new.properties")
// vit can be here or obave class that @SpringBootApplication but we need it here
public class TryInvironment {

    @Autowired
    public Environment en;            // it didn't work in class that being configered with @SpringBootApllication

    @Value("${application.name}")
    public String value;     // it didn't work in class that being configered with @SpringBootApllication

    @Bean
    public void getValue() {
        System.out.println(value + "\n" + en.getProperty("application.name"));
    }
}
