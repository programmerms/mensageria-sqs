
package com.seuprojeto.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.seuprojeto")
public class ProtocoloKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProtocoloKafkaApplication.class, args);
    }
}
