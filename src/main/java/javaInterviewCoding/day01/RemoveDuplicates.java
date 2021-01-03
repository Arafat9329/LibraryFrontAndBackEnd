package javaInterviewCoding.day01;

public class RemoveDuplicates {
    /*
    Write a return method that can remove the duplicated values from String

    Ex:  removeDup("AAABBBCCC")  ==> ABC
     */

    public static void main(String[] args) {
        String str ="AAABBC";

        String nonDup="";

        for (int i = 0; i <str.length() ; i++) {
            if (!nonDup.contains(str.charAt(i)+"")){
                nonDup+=str.charAt(i);
            }
        }
        System.out.println("nonDup = " + nonDup);
    }
}
