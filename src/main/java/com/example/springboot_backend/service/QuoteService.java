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


    @Autowired
    private QuoteRepo quoteRepo;


    public List<Quote> getListOfQuotes() throws IOException {
//        List<Quote> quotes2 = new ArrayList<>();
//
        List<Quote> quotes = new ArrayList<>();
//
////        List<Quote> quotes1 = intiDummyData();
////        quoteRepo.saveAll(quotes1);
        quoteRepo.findAll().forEach(quotes::add);
        return quotes;
//        return quoteRepo.g();
    }





    public void saveQuote(Quote quote) {
        quoteRepo.save(quote);
    }


    public void deleteQuote(long id) {

        if (!quoteRepo.existsById(id)) {
            throw new IllegalStateException("Quote Not Exist");
        } else {
            quoteRepo.deleteById(id);

        }
    }

    public List<Quote> getQuoteWithAuthor(@Param(value = "author") String author) {
        List<Quote> quoteList = new ArrayList<>();
        quoteList = quoteRepo.findQuotesByAuthor(author);
        logger.info(" quoteList : " + String.valueOf(quoteList.size()));
        return quoteList;
    }

    public Quote getQuote(long id) {
        return quoteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Quote Not Found"));
    }


//public void updateQuote(Quote quote, long id) {
////        Optional<Quote> quoteOptional = quoteRepo.findById(id);
//    Quote q = quoteRepo.findById(id).orElseThrow(() -> new IllegalStateException(
//            "not found" + id + ""
//    ));
//    if (q != null) {
//        q.setId(quote.getId());
//    }
////        if (quoteOptional.isEmpty()){
////            System.out.println("SS");
////        }
////        else {
////            quote.setId(55);
////            quote.setQuoteText(quote.getQuoteText());
////            quoteRepo.save(quote);
////        }
//
//
//}

}

