package com.bazi.ttmk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TtmkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TtmkApplication.class, args);
    }

}
