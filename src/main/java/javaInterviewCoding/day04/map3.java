package javaInterviewCoding.day04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/*
Map -- Min value
Write a method that can return the minimum value from ta map (DO NOT use sort method)
 */
public class map3 {

    public static void main(String[] args) {
        Map<String,Integer>map = new LinkedHashMap<>();
        map.put("test1",2);
        map.put("test2",1);
        map.put("test3",-222);
        map.put("test4",2);
        map.put("test5",252);

        int min = Integer.MAX_VALUE;
        for (Integer each:map.values()) {
            if (each<min){
                min= each;
            }
        }
        System.out.println("min = " + min);

        SortedSet<Integer> sm = new TreeSet<>(map.values());
        System.out.println(sm.last());


    }
}
