package com.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BorrowingBooks {
    private int id;
    private String name;
    private int disabled;
}
