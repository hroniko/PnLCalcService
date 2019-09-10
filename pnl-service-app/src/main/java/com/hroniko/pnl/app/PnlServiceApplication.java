package com.hroniko.pnl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.hroniko.pnl.*"})
@EnableNeo4jRepositories("com.hroniko.pnl.repositories")
@EntityScan(basePackages = "com.hroniko.pnl.entities")
@EnableConfigurationProperties
public class PnlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnlServiceApplication.class, args);
    }

}
