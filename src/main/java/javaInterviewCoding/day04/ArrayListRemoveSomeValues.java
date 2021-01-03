package javaInterviewCoding.day04;

/*
Given a list of Integers 1, 2, 3, 4, 5, 6 ....etc. remove all values greater than 100.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRemoveSomeValues {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,101,200,300));

        list1.removeIf(each -> each>100);
        System.out.println("list1 = " + list1);
    }


}
