package com.dh.catalogservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movies")
public record Movie(@Id Long id, String name, String genre, String urlStream) {
}
