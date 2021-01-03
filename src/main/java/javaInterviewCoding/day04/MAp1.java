package javaInterviewCoding.day04;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MAp1 {
    /*
    Map -- Frequency of Characters
Write a method that prints the frequency of each character from a String
     */

    public static void main(String[] args) {
        String str = "akjsfhkaf";

        Map<String,Integer>map = new LinkedHashMap<>();

        for (String each:str.split("")) {
            map.put(each, Collections.frequency(Arrays.asList(str.split("")),each));
        }

        System.out.println("map = " + map);

    }
}
