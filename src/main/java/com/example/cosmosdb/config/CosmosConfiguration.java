package com.example.cosmosdb.config;

import static com.example.cosmosdb.config.Constants.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.cosmosdb.repository.UsersRepository;
import com.microsoft.azure.documentdb.ConnectionMode;
import com.microsoft.azure.documentdb.ConnectionPolicy;
import com.microsoft.azure.documentdb.ConsistencyLevel;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.FeedOptions;
import com.microsoft.azure.spring.data.cosmosdb.config.AbstractDocumentDbConfiguration;
import com.microsoft.azure.spring.data.cosmosdb.config.DocumentDBConfig;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;

/*
@Configuration
public class CosmosConfiguration{
    private String cosmosEndPoint = HOST_URI;
    private String key = PRIMARY_KEY;

    @Bean
    public DocumentClient initCosmosConnection(){
        System.out.println("init cosmos DB..");
        ConnectionPolicy policy = ConnectionPolicy.GetDefault();
        policy.setConnectionMode(ConnectionMode.DirectHttps);
        policy.setPreferredLocations(new ArrayList<String>(){{
            add("Central US");
            add("East US 2");
        }});
        DocumentClient client = new DocumentClient(cosmosEndPoint, key, policy, ConsistencyLevel.Session);
            client.readDatabases(new FeedOptions()).getQueryIterator().forEachRemaining(database -> {
            	System.out.println("Spring database link = " + database.getSelfLink());
        });
        System.out.println("cosmos connection got created....");
        return client;
    }
}
*/

@Primary
@Configuration
@EnableDocumentDbRepositories(basePackages="com.example.cosmosdb.repository")
public class CosmosConfiguration extends AbstractDocumentDbConfiguration {

    @Value("${azure.cosmosdb.uri}")
    private String uri;

    @Value("${azure.cosmosdb.key}")
    private String key;

    @Value("${azure.cosmosdb.database}")
    private String dbName;
    
    public DocumentDBConfig getConfig() {
        return DocumentDBConfig.builder(uri, key, dbName).build();
    }

    @Bean 
    public DocumentClient config() {
    	DocumentClient client = new DocumentClient(
        		uri, key, ConnectionPolicy.GetDefault(), ConsistencyLevel.Session);
        client.readDatabases(new FeedOptions()).getQueryIterator().forEachRemaining(database -> {
        	System.out.println("Spring database link = " + database.getSelfLink());
    });
    	return client;
    }
}