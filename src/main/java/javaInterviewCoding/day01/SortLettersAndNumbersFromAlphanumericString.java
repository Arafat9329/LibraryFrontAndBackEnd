package javaInterviewCoding.day01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLettersAndNumbersFromAlphanumericString {

    /*
            Given alphanumeric String, we need to split the string into substrings of consecutive letters or numbers, sort the individual string and append them back together

        Ex:

        Input:  "DC501GCCCA098911"

        OutPut: "CD015ACCCG011899"
     */

    public static void main(String[] args) {

        String str = "DC501GCCCA098911";



        String[] split = str.split("(?<=\\D)(?=\\d)");
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));
        String result = "";
        for (String each : split) {
            List<String> temp = Arrays.asList(each.split(""));
            Collections.sort(temp);
            result += temp;
        }
        System.out.println("result = " + result);
        System.out.println(result.replaceAll("[,\\[\\] ]", ""));

//        String str = "DC501GCCCA098911";
//
//        ArrayList<String>arrList= new ArrayList<>();
//        String addOn="";
//
//        for (int i = 0; i<str.length();i++){
//            addOn+=str.charAt(i)+"";
//            if (Character.isLetter(str.charAt(i))&&i<str.length()-1){
//                if (Character.isDigit(str.charAt(i+1))){
//                    addOn+=",";
//                }
//            }
//
//            if (Character.isDigit(str.charAt(i)) && i<str.length()-1){
//                if (Character.isLetter(str.charAt(i+1))){
//                    addOn+=",";
//                }
//            }
//        }
//        System.out.println("addOn = " + addOn);
//        String[] arr = addOn.split(",");
//        System.out.println("arr = " + Arrays.toString(arr));
//
//        str="";
//        for (String each :arr) {
//            char[] chars = each.toCharArray();
//
//            Arrays.sort(chars);
//            for (char eachChar:chars) {
//                str+=eachChar+"";
//            }
//
//        }
//        System.out.println("str = " + str);
//
//        System.out.println("sort_AlphanumericString(\"DC501GCCCA098911\") = " + sort_AlphanumericString("DC501GCCCA098911"));


    }

    public static String sort_AlphanumericString(String str) {

        String str2 = "";
        for (int i = 0; i <= str.length() - 1; i++) {

            str2 +=str.charAt(i)+"";

            if (Character.isAlphabetic(str.charAt(i)) && i < str.length() - 1) {

                if (Character.isDigit(str.charAt(i + 1))) {

                    str2 += ",";

                }

            }

        }

        String result ="";
        String[] arr = str2.split(","); //50AB, 12CD....

        for( String each : arr){

            char[] temp = each.toCharArray();

            Arrays.sort(temp);

            for (char eachChar : temp){

                result+=eachChar+"";
            }

        }


        return result;

    }

}
