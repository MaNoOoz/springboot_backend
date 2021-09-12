package com.example.springboot_backend.data;

import com.example.springboot_backend.models.Quote;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@SpringBootTest
//@DataJpaTest
public interface QuoteRepo extends JpaRepository<Quote, Long> {


    @Query(value = "select q from Quote q where q.author = :author")
    List<Quote> findQuotesByAuthor(String author);
}
