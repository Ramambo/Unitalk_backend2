package com.unitalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UnitalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitalkApplication.class, args);
    }

}
