package com.example.cosmosdb;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.cosmosdb.config.CosmosConfiguration;
//import com.example.cosmosdb.config.CosmosConfiguration;
import com.example.cosmosdb.entity.Users;
import com.example.cosmosdb.repository.UsersRepository;
import com.google.gson.Gson;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.spring.data.cosmosdb.repository.config.EnableDocumentDbRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.example.cosmosdb.config")
public class CosmosdbApplication implements CommandLineRunner{
	@Autowired private UsersRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CosmosdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String json = new String(Files.readAllBytes(Paths.get("sample.json")));
		Users[] users = new Gson().fromJson(json, Users[].class);

		for (final Users user : users) {
			repository.save(user);
		}
		
		/*repository.
		
		final Optional<Users> user = repository.findById("1");
		if (user.isPresent()) System.out.println("User=" + user);
		else System.out.println("user is NULL!");
		
		for (User user : users) {
			if (repository.count() > 0 && !repository.existsById(user.getUserId()))
				repository.save(user);
			
			
			 else {
				Optional<User> userFromDb = repository.findById(user.getUserId());
				String.format("Found User With id=%i: %s", 
					user.getUserId(), 
					((userFromDb.isPresent()) ? userFromDb : "null")
				);
			}
			
		}
		*/
		
	}

}
