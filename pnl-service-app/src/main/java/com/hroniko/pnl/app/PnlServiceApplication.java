package com.hroniko.pnl.app;

import com.arangodb.springframework.annotation.EnableArangoRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.hroniko.pnl.*"})
@EnableArangoRepositories("com.hroniko.pnl.repositories")
@EntityScan(basePackages = "com.hroniko.pnl.entities")
@EnableConfigurationProperties
public class PnlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnlServiceApplication.class, args);
    }

}
