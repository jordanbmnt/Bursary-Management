package com.bbd.bursary.manager;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Program {
        public static void main(String[] args) {
                SpringApplication.run(Program.class, args);
        }


}