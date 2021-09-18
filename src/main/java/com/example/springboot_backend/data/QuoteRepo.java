package com.example.springboot_backend.data;

import com.example.springboot_backend.models.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface QuoteRepo extends MongoRepository<Quote, Long> {

    @Query("{author : ?0}")
    List<Quote> findQuotesByAuthor(String author);
}
