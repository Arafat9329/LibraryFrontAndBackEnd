package javaInterviewCoding.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;

public class FrequencyOfCharacters {

    /*
    Write a return method that can find the frequency of characters

    Ex:  FrequencyOfChars("AAABBCDD") ==> A3B2C1D2
     */

    public static void main(String[] args) {
        String str = "AABBC";
        String result="";

        for (int j = 0; j <str.length() ; j++) {
            int count = 0;
            String tg = str.charAt(j) + "";
            for (int i = 0; i < str.length(); i++) {
                if ((str.charAt(i) + "").equals(tg)) {
                    count++;
                }
            }
            if (!result.contains(tg)){
                result+=tg+count;
            }

        }
        System.out.println(result);


        System.out.println("frequencyOfCharacters1(\"AABBC\") = " + frequencyOfCharacters1("AABBC"));

        System.out.println("====================================================");

        String message ="john Smith 21";

        //IntStream

        ArrayList<String>arrList = new ArrayList<>(Arrays.asList(str.split("")));
        //arrList.removeIf(each ->Collections.frequency(arrList,each)!=1);
        System.out.println("arrList = " + arrList);

        StringBuffer str1 = new StringBuffer("abc");




        for (String each :arrList) {
            System.out.println(each +Collections.frequency(arrList,each) );

        }


    }

    public static String frequencyOfCharacters1(String word){
        //this.word = "test";
        String result="";
        for (int j = 0; j <word.length() ; j++) {
                int count = 0;
                char tg = word.charAt(j);
                for (int i = 0; i <word.length(); i++) {
                    if (word.charAt(i)==tg){
                        count++;
                    }

                }
            if (!result.contains(tg+"")){
                result+=tg+""+count;
            }

        }
        return result;

    }

    public static String FrequencyOfChars2(String str) {

        String nonDup = "";

        for(int i=0; i < str.length(); i++) {

            if (!nonDup.contains("" + str.charAt(i)))

                nonDup += "" + str.charAt(i);
        }

        String expectedResult = "";
        for( int j=0;j < nonDup.length(); j++) {

            int count = 0;

            for(int i=0; i < str.length(); i++) {

                if(str.charAt(i) == nonDup.charAt(j))

                    count++;

            }

            expectedResult +=nonDup.charAt(j)+"" + count;

        }

        return expectedResult;

    }

    public  static  String  FrequencyOfChars3(String str) {

        String expectedResult = "";

        for( int j=0; j < str.length(); j++) {

            int count = 0;

            for(int i=0; i < str.length(); i++) {

                if(str.charAt(i) == str.charAt(j)) {

                    count++;

                }

            }

            expectedResult +=str.charAt(j)+"" + count;

            str = str.replace(""+str.charAt(j) ,  "" );

        }

        return expectedResult;

    }

    public  static  String  FrequencyOfChars4(String str) {

        String b=new LinkedHashSet<>(Arrays.asList(str.split(""))).toString();

        b = b.replace(", ","").replace("[","").replace("]","");

        String result="";

        for(int j=0; j<b.length();j++) {

            int count=0;

            for(int i=0; i<str.length(); i++){

                if(str.substring(i, i+1).equals(""+str.charAt(j)))

                    count++;

            }

            result+=b.substring(j, j+1)+count;

        }

        return result;

    }

    public static String frequency5(String str) {

        String nonDup="", result="";

        for(int i=0; i < str.length(); i++)

            if(! nonDup.contains(""+str.charAt(i))) {

                nonDup += "" + str.charAt(i);
            }



        for(int i=0; i < nonDup.length(); i++) {

            int num = Collections.frequency( Arrays.asList(str.split("") ) ,    ""+nonDup.charAt( i ) );

            result += ""+nonDup.charAt(i) + num;

        }



        return result;

    }


}
