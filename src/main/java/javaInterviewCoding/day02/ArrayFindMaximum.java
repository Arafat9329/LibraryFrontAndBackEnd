package javaInterviewCoding.day02;

public class ArrayFindMaximum {

    public static void main(String[] args) {
        int [] strArr = {-5,9,3,1,0,9,-10};
        int max = strArr[0];

        for (int each :strArr) {
            if (each>max){
                max= each;
            }
        }

        System.out.println(max);
    }
}
