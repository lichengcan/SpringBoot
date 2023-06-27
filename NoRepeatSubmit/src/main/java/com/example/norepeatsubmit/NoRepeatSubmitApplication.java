package com.example.norepeatsubmit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lichengcan
 */
@SpringBootApplication
@ComponentScan("com.example.norepeatsubmit.*")
public class NoRepeatSubmitApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoRepeatSubmitApplication.class, args);
    }

}
