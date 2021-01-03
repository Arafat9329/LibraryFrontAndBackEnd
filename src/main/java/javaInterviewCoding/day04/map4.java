package javaInterviewCoding.day04;

import java.util.*;

public class map4 {
    /*
    Map -- Sort the map by values
Write a method that can sort the Map by values


     */

    public static void main(String[] args) {


        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("test1",2);
        map.put("test2",1);
        map.put("test3",-222);
        map.put("test4",2);
        map.put("test5",252);
        System.out.println("map = " + map);


        ArrayList<Integer>intList = new ArrayList<>(map.values());
        Collections.sort(intList);
        System.out.println("intList = " + intList);

        Map<String,Integer>map2 = new LinkedHashMap<>();


        for (Integer each : intList) {

            for (Map.Entry<String,Integer> eachOne : map.entrySet()  ){
                if (eachOne.getValue()==each){
                    map2.put(eachOne.getKey(),eachOne.getValue());
                }
            }



        }
        System.out.println("map2 = " + map2);
        }


    public static Map<String, Integer>  sortByValue(Map<String, Integer> map){

        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        map = new LinkedHashMap();

        for(Map.Entry<String, Integer> each : list) {

            map.put(each.getKey(), each.getValue());

        }

        return map;

    }
}
