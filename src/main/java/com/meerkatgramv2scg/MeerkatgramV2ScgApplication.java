package com.meerkatgramv2scg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class MeerkatgramV2ScgApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeerkatgramV2ScgApplication.class, args);
    }

}
