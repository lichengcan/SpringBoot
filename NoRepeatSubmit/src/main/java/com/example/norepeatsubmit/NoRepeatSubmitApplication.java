package com.example.norepeatsubmit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lichengcan
 * 防止重复提交的自定义注解
 */
@SpringBootApplication
@ComponentScan("com.example.norepeatsubmit.*")
public class NoRepeatSubmitApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoRepeatSubmitApplication.class, args);
    }

}
