package com.utils;

import com.POJO.StudentUserPayLoad;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class JavaFakerUtil {

    public static void main(String[] args) {
        System.out.println(createRandomStudentPOJO());
    }


    public static StudentUserPayLoad createRandomStudentPOJO() {

        // creating faker instances
        Faker faker = new Faker();

        // creating object to store new student information
        StudentUserPayLoad studentUserPayLoad = new StudentUserPayLoad();

        //creating fake full name
        studentUserPayLoad.setFull_name(faker.name().fullName());

        //creating fake gmail
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        studentUserPayLoad.setEmail(fakeValuesService.bothify("????##@gmail.com"));

        // creating fake password
        studentUserPayLoad.setPassword(faker.regexify("[A-Za-z1-9]{10}"));

        // creating fake full address
        studentUserPayLoad.setAddress(faker.address().fullAddress());

        // creating fake status using random method to pick only from active and inactive
        List<String> status = new ArrayList<>(Arrays.asList("ACTIVE", "INACTIVE"));
        studentUserPayLoad.setStatus(getRandomElement(status));

        // creating fake start date , getting current date as start date
        LocalDate now = LocalDate.now();
        studentUserPayLoad.setStart_date(now.toString());

        // creating fake end date
        studentUserPayLoad.setEnd_date(now.plusYears(1).toString());

        // set group id
        studentUserPayLoad.setUser_group_id("3");

       return studentUserPayLoad;

    }


    public static String getRandomElement(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }



}
