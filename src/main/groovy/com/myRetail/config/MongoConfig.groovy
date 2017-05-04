package com.myRetail.config

import com.mongodb.Mongo
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

/**
 * Created by miker on 5/2/17.
 */
@Configuration
@EnableMongoRepositories(basePackages = 'com.myRetail.dao')
class MongoConfig extends AbstractMongoConfiguration {
    @Value('${mongo.host:127.0.0.1}')
    private String mongoHost

    @Value('${mongo.port:27017}')
    private int mongoPort

    @Value('${mongo.database:myRetail}')
    private String mongoDatabase

    @Override
    protected String getDatabaseName() {
        return mongoDatabase
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost, mongoPort)
    }
}