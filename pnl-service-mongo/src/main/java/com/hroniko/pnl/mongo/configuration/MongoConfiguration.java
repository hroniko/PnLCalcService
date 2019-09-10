package com.hroniko.pnl.mongo.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories("com.hroniko.pnl.mongo.repositories")
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {
    @Override
    public MongoClient reactiveMongoClient() {
        // Instantiate MongoClient with default settings: mongodb://localhost
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "spring-reactive-mongodb";
    }
}
