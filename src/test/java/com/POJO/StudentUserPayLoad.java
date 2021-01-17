package com.POJO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StudentUserPayLoad {

    private String full_name;
    private String email;
    private String password;
    private String user_group_id;
    private String status;
    private String start_date;
    private String end_date;
    private String address;
    private String token;
    private String id;


}
