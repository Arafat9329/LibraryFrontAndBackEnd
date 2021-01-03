package javaInterviewCoding.day01;

public class Reverse {
    /*
    Write a return method that can reverse  String

    Ex: day01.Reverse("ABCD"); ==> DCBA
     */

    public static void main(String[] args) {
        String str  ="Arrppat";

        for (int i = str.length()-1; i >=0 ; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        StringBuffer strr = new StringBuffer("Arrppat");
        System.out.println("strr.reverse() = " + strr.reverse());
    }
}
