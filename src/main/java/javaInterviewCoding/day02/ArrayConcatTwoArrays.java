package javaInterviewCoding.day02;

import java.util.Arrays;

public class ArrayConcatTwoArrays {

    public static void main(String[] args) {
        String [] arr1 = {"tes10","tes13","tes12","tes14","tes16","tes51","tes23",};
        String [] arr2 = {"tes0","te","12","14","16","51","23",};

        String []arrFin = new String[arr1.length+arr2.length];

        int i=0;

        for (String each:arr1) {
            arrFin[i]=each;
            i++;
        }

        for (String each :arr2) {
            arrFin[i]=each;
            i++;
        }

        System.out.println("Arrays.toString(arrFin) = " + Arrays.toString(arrFin));
    }
}
