package javaInterviewCoding.day02;

import java.util.Arrays;

public class ArraysMoveZerosTheEnd {

    public static void main(String[] args) {
        int arr[]=  {1,0,2,0,3,0,4,0};
        int []arr2= new int[arr.length];

        int i= arr.length-1;


        for (int each:arr) {
            if (each == 0) {
                arr2[i] = 0;
                i--;
            }
        }

        i=0;
        for (int each:arr) {
            if (each != 0) {
                arr2[i] = each;
                i++;
            }
        }



        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));
    }
}
