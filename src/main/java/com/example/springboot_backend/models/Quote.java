package com.example.springboot_backend.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("quote")
public class Quote {


    @Id
    long id;

    @Field("quoteText")
    @Indexed(unique = false)
    String quoteText;

    @Field("author")
    @Indexed(unique = false)
    String author;


}
