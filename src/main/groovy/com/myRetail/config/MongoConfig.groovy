package com.myRetail.config

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by miker on 5/2/17.
 */
@Configuration
@EnableMongoRepositories(basePackages = 'com.myRetail.dao')
public class MongoConfig extends AbstractMongoConfiguration {

    //TODO: is all this needed?

    @Override
    protected String getDatabaseName() {
        return "myRetail";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}