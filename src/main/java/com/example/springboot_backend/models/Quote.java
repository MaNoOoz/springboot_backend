package com.example.springboot_backend.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Quotes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

//
//    public Quote( String quoteText, String author) {
////        this.id = id;
//        this.quoteText = quoteText;
//        this.author = author;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "quote_text")
    String quoteText;

    @Column(name = "author")
    String author;


}
