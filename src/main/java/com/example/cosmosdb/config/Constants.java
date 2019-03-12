package com.example.cosmosdb.config;

import lombok.Data;

@Data
public class Constants {
    public static final String HOST_URI = "https://com-revature.documents.azure.com:443/";
    public static final String PRIMARY_KEY = "eYNTVzDnXoaLaChFQQJrvjksWSm8lhjZqGObl3L1u0EZG6U3SwTPhgHPlP3ZytxtbgeyHJaqaDeTPghsK2CqTw==";
    public static final String DATABASE_NAME = "ToDoList";
    public static final String COLLECTION_NAME = "users";
    public static final String PARTITION_KEY = "/email";
}
