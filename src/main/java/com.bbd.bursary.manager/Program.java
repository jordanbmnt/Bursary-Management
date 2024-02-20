package com.bbd.bursary.manager;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableAutoConfiguration
@SpringBootApplication
public class Program {
        public static void main(String[] args) {
                SpringApplication.run(Program.class, args);
        }
}