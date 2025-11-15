package com.springdiaryproject.springdiarydevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ServletComponentScan
public class SpringDiaryDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDiaryDevelopApplication.class, args);
    }

}
