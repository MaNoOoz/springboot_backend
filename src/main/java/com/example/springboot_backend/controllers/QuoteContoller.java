package com.example.springboot_backend.controllers;


// API Layer - > Logic

import com.example.springboot_backend.models.Quote;
import com.example.springboot_backend.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuoteContoller {


    @Autowired
    public QuoteService quoteService;

    public QuoteContoller(QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    // GET All======================================================
    // http://192.168.1.2:8080/api/v1/quotes
    @GetMapping(path = "/api/v1/quotes")
    List<Quote> getQuotes()  {

        return quoteService.getAllQuotes();
    }
    // GET One ======================================================

    @GetMapping(path = "api/v1/quotes/{quoteId}")
    Quote getQuote(@PathVariable(name = "quoteId") long id) {
        return quoteService.getQuoteById(id);
    }
    // GET Query ======================================================

//    http://192.168.1.2:8080/api/v1/quotes?author=al walid
    @GetMapping(path = "api/v1/quotes", params = {"author"})
    List<Quote> getQuotesByAuthor(@RequestParam(value = "author", required = false) String author) {
        return quoteService.getQuoteWithAuthor(author);
    }

    // Add New Query ======================================================

    @PostMapping(path = "api/v1/quotes")
    void addNewQuoteOrUpdate(@RequestBody(required = true) Quote quote) {
        quoteService.saveQuote(quote);
    }


    // Delete New Query ======================================================

    //    http://192.168.1.2:8080/api/v1/quotes/1
    @DeleteMapping(path = "api/v1/quotes/{quoteId}")
    void removeQuote(@PathVariable(name = "quoteId") long id) {
        quoteService.deleteQuote(id);
    }

    // Update  ======================================================

//    @PutMapping(path = "api/v1/quotes/{id}")
//    public ResponseEntity updateQuote( @PathVariable(name = "id") long id ,@RequestBody Quote expense) {
//        quoteService.updateQuote(id,expense);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
