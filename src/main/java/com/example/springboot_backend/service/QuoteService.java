package com.example.springboot_backend.service;


//  logic layer

import com.example.springboot_backend.data.QuoteRepo;
import com.example.springboot_backend.models.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class QuoteService {

    Logger logger = LoggerFactory.getLogger(QuoteService.class);
    private final QuoteRepo quoteRepo;

//======================================================
    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }
//======================================================
    public List<Quote> getAllQuotes() {

        List<Quote> quotes = new ArrayList<>();

        quoteRepo.findAll().forEach(quotes::add);
        return quotes;
    }
//======================================================
    public void saveQuote(Quote Quote) {
        quoteRepo.insert(Quote);
    }
//======================================================
    public void deleteQuote(long id) {

        if (!quoteRepo.existsById(id)) {
            throw new IllegalStateException("Quote2 Not Exist");
        } else {
            quoteRepo.deleteById(id);

        }
    }
//======================================================
    public List<Quote> getQuoteWithAuthor(@Param(value = "author") String author) {
        List<Quote> quoteList = new ArrayList<>();
        quoteList = quoteRepo.findQuotesByAuthor(author);
        logger.info(" QuoteList : " + String.valueOf(quoteList.size()));
        return quoteList;
    }
//======================================================
    public Quote getQuoteById(long id) {
        return quoteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quote2 Not Found"));
    }
//======================================================

//    public void updateQuote(long id , Quote updateQuote) {
//        Quote savedExpense = quoteRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", updateQuote.getId())));
//        savedExpense.setQuoteText(updateQuote.getQuoteText());
//        savedExpense.setAuthor(updateQuote.getAuthor());
//
//        quoteRepo.save(updateQuote);
//    }


}

