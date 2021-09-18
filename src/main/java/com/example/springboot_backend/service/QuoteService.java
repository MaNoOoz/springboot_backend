package com.example.springboot_backend.service;


//  logic layer

import com.example.springboot_backend.data.QuoteRepo;
import com.example.springboot_backend.models.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuoteService {

    Logger logger = LoggerFactory.getLogger(QuoteService.class);

    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }
    private QuoteRepo quoteRepo;

    // =====================================================
    public List<Quote> getListOfQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quoteRepo.findAll().forEach(quotes::add);
        return quotes;
    }

    // =====================================================
    public void saveQuote(Quote quote) {
        quoteRepo.save(quote);
    }

    // =====================================================
    public void deleteQuote(long id) {

        if (!quoteRepo.existsById(id)) {
            throw new IllegalStateException("Quote Not Exist");
        } else {
            quoteRepo.deleteById(id);

        }
    }

    // =====================================================
    public List<Quote> getQuoteWithAuthor(@Param(value = "author") String author) {
        List<Quote> quoteList = new ArrayList<>();
        quoteList = quoteRepo.findQuotesByAuthor(author);
        logger.info(" quoteList : " + String.valueOf(quoteList.size()));
        return quoteList;
    }

    // =====================================================
    public Quote getQuote(long id) {
        return quoteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quote Not Found"));
    }
    // =====================================================

}

