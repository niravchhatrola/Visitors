package com.chhatrola.visitors.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages={"com.chhatrola.visitors.web"})
@EnableJpaRepositories(basePackages = "com.chhatrola.visitors.web.repository")
public class BranchVisitRunner {
    public static void main(String[] args) {
        SpringApplication.run(BranchVisitRunner.class, args);
    }
}
