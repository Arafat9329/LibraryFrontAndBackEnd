package javaInterviewCoding.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Unique {

/*
    Write a return  method that can find the unique characters from the String

    Ex:  unique("AAABBBCCCDEF")  ==>  "DEF";
 */
    public static void main(String[] args) {
        String str ="AAAAAABCCCDEF";


        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(str.split("")));

        for (String each: arrList) {
            if (Collections.frequency(arrList,each)==1){
                System.out.println("each = " + each);
            }
        }




    }
}
