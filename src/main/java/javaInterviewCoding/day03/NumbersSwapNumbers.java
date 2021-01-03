package javaInterviewCoding.day03;


import java.util.LinkedHashMap;
import java.util.Map;

/*
Swap two variable' values without using a third variable
 */
public class NumbersSwapNumbers {

    public static void main(String[] args) {
//        int  a = 10;
//        int  b  = 20;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//
//        a = a +b;
//        b = a - b;
//        a = a - b;
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);

        int  a = 10;      int  b  = 20;

        a = a^b;
        System.out.println("a = " + a);

        b = a^b;
        System.out.println("b = " + b);

        a = a^b;
        System.out.println("b = " + b);

        Map<String,Integer>map = new LinkedHashMap<>();
        map.put("test",1);
        map.put("test2",2);
        map.put("test3",2);
        map.put("test4",4);
        map.put("test5",4);




    }
}
