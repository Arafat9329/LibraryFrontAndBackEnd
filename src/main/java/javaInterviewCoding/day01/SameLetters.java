package javaInterviewCoding.day01;

import java.util.Arrays;

public class SameLetters {

    /*
    Write a return method that check if a string is build out of the same letters as another string.

    Ex:  same("abc",  "cab"); -> true

    same("abc",  "abb"); -> false:
     */
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cab";

        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        System.out.println("arr1 = " + Arrays.toString(arr1));
        Arrays.sort(arr2);
        System.out.println("arr2 = " + Arrays.toString(arr2));

        System.out.println(Arrays.equals(arr1,arr2));

    }
}
