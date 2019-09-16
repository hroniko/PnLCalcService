package com.hroniko.pnl.app;

import com.hroniko.pnl.entities.catalog.Capex;
import com.hroniko.pnl.entities.catalog.Opex;
import com.hroniko.pnl.entities.nodes.CalcNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;


@SpringBootApplication
@ComponentScan(basePackages = {"com.hroniko.pnl.*"})
@EnableOrientRepositories(basePackages = "com.hroniko.pnl.repositories")
@EntityScan(basePackages = "com.hroniko.pnl.entities")
@EnableConfigurationProperties
@EnableTransactionManagement
public class PnlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PnlServiceApplication.class, args);
    }

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory =  new OrientObjectDatabaseFactory();

        factory.setUrl("remote:localhost/pnl-dervice");
        factory.setUsername("root");
        factory.setPassword("secret");

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }


    @PostConstruct
    public void registerEntities() {
        factory().db().getEntityManager().registerEntityClass(CalcNode.class);
//        factory().db().getEntityManager().registerEntityClass(Capex.class);
//        factory().db().getEntityManager().registerEntityClass(Opex.class);
    }

}
