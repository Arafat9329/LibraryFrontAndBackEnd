package javaInterviewCoding.day02;

import java.util.Arrays;

public class ArrayFindMinimum {
    public static void main(String[] args) {
        int arr[] = {98,12,65,63,14,66};
        Arrays.sort(arr);

        int min = arr[0];
        System.out.println("min = " + min);
    }
}
