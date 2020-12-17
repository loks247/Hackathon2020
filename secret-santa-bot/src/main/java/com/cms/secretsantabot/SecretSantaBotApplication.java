package com.cms.secretsantabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.cms.secretsantabot.repository")
public class SecretSantaBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretSantaBotApplication.class, args);
    }
}
