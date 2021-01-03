package javaInterviewCoding.day04;

public class NumberReverseNegativeNumber {
    public static void main(String[] args) {

        System.out.println("reverseNum(-1234) = " + reverseNum(-1234));
    }
    public static int reverseNum(int  num) {
        String str = new StringBuilder(""+num).reverse().toString();

        if(num < 0) {
            str = "-"+str.substring(0, str.length()-1);
        }
        return Integer.valueOf(str);

    }

    public static void reverseNumber(int num){
        int reversed = 0;

        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        System.out.println("Reversed Number: " + reversed);
    }





}
