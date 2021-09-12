package com.example.springboot_backend.controllers;


// API Layer - > Logic

import com.example.springboot_backend.models.Quote;
import com.example.springboot_backend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;


@RestController
public class QuoteContoller {


    @Autowired
    public QuoteService quoteService;

    public QuoteContoller(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // http://192.168.1.2:8080/api/v1/quotes
    @GetMapping(path = "/api/v1/quotes")
    List<Quote> getQuotes() throws IOException {

        return quoteService.getListOfQuotes();
    }

    @GetMapping(path = "api/v1/quotes/{quoteId}")
    Quote getQuote(@PathVariable(name = "quoteId") long id) {
        return quoteService.getQuote(id);
    }

    //http://192.168.1.2:8080/api/v1/quotes?author=al walid
//    @GetMapping(path = "api/v1/quotes", params = {"author"})
//    List<Quote> getQuotesByAuthor(@RequestParam(value = "author", required = false) String author) {
//        return quoteService.getQuoteWithAuthor(author);
//    }


    @PostMapping(path = "api/v1/quotes")
    void addNewQuoteOrUpdate(@RequestBody(required = true) Quote quote) {
        quoteService.saveQuote(quote);
    }


    //    http://192.168.1.2:8080/api/v1/quotes/1
    @DeleteMapping(path = "api/v1/quotes/{quoteId}")
    void removeQuote(@PathVariable(name = "quoteId") long id) {
        quoteService.deleteQuote(id);
    }


}
