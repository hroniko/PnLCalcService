package com.hroniko.pnl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@EnableNeo4jRepositories("com.hroniko.pnl.repositories")
@SpringBootApplication
@ComponentScan(basePackages = {"com.hroniko.pnl"})
@EnableConfigurationProperties
public class PnlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnlServiceApplication.class, args);
    }

}
