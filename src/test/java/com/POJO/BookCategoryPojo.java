package com.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data


public class BookCategoryPojo {
    private String id;
    private String name;



    public static void main(String[] args) {
        BookCategoryPojo bookCategoryPojo =  new BookCategoryPojo();


    }
}
