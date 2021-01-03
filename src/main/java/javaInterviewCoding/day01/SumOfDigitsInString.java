package javaInterviewCoding.day01;

public class SumOfDigitsInString {
    /*
    Write a method that can return the sum of the digits in a string
     */

    public static void main(String[] args) {
       String str ="test223";

        int sum=0;
        for (Character each :str.toCharArray()) {
            if (Character.isDigit(each)) sum+=Integer.parseInt(each+"");
        }
        System.out.println("sum = " + sum);
    }

    public  static int  sumOfDigits(String s) {

        int total = 0;

        char[] ch =  s.toCharArray();

        for(char each: ch) {

            if(Character.isDigit(each)) {

                total += Integer.valueOf(""+each);

            }

        }

        return total;

    }

    public static  int sumOfnum(String str){
        str ="test223";

        int sum=0;
        for (Character each :str.toCharArray()) {
            if (Character.isDigit(each)) sum+=Integer.parseInt(each+"");

        }
return sum;

    }
}
