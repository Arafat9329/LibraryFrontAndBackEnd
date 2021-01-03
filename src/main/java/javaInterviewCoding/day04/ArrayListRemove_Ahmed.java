package javaInterviewCoding.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
Given a list of people' names: "Ahmed", "John", Eric", "Ahmed".....
Write a java operation to remove all the names named Ahmed
 */
public class ArrayListRemove_Ahmed {





    public static void main(String[] args) {
        /*
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList("Ahmed", "John", "Eric", "Ahmed"));
        arrList.removeAll(Arrays.asList("Ahmed"));
         */
/*

        List<String> names = new ArrayList<>(Arrays.asList("Ahmed", "John", "Eric", "Ahmed"));

        ListIterator<String> it = names.listIterator();

        while (it.hasNext()) {

            if (it.next().equals("Ahmed")){
                System.out.println("");
            }

        }

        while (it.hasPrevious()) {

            if (it.previous().equals("Ahmed")) {

                it.remove();
            }
        }
        System.out.println(names);

*/

/*
        List<String> names = new ArrayList<>(Arrays.asList("Ahmed", "John", "Eric", "Ahmed"));

        List<String> names2 = new ArrayList<>();

        names.forEach(p-> {if(!p.equals("Ahmed")) names2.add(p);}  );

        System.out.println(names2);
*/

        ListIterator<String> litr = null;
        List<String> names = new ArrayList<String>();
        names.add("Shyam");
        names.add("Rajat");
        names.add("Paul");
        names.add("Tom");
        names.add("Kate");
        //Obtaining list iterator
        litr = names.listIterator();

//        System.out.println("Traversing the list in forward direction:");
//        while (litr.hasNext()) {
//
//            System.out.println(litr.next());
//            litr.set("test");
//            System.out.println("names = " + names);
//
//        }


        System.out.println("\nTraversing the list in backward direction:");
        while (litr.hasPrevious()) {
            System.out.println(litr.previous());
            litr.set("test");
        }
        System.out.println("names = " + names);

    }



    }
