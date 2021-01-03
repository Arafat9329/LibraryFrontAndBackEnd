package javaInterviewCoding.day04;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Map2 {

    public static void main(String[] args) {
        String str ="accabbcd";

        String unique= "";
        Map<String,Integer> map = new LinkedHashMap<>();

        for (String each:str.split("")){
            if (Collections.frequency(Arrays.asList(str.split("")),each)==1){
                map.put(each,1);
            }
        }
        System.out.println("map = " + map);

    }
}
