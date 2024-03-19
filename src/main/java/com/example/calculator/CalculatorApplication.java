package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {
    //  @Bean
    // public PasswordEncoder passwordEncoder(){
    //       return new BCryptPasswordEncoder();
    // }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);

    }

}
