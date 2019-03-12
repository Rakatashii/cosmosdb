package com.example.cosmosdb.repository;


import org.springframework.stereotype.Repository;

import com.example.cosmosdb.entity.Users;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
public interface UsersRepository extends DocumentDbRepository<Users, String> {
	
}
