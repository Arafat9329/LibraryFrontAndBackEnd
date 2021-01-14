package com.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BookPayLoad {
    private String id;
    private String name;
    private String isbn;
    private String year;
    private String author;
    private String book_category_id;
    private String description;

}
