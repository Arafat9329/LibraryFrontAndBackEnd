package javaInterviewCoding.day03;

public class NumbersDivideWithoutOperator {
    /*
    Write a method that can divide two numbers without using division operator
     */

    public static void main(String[] args) {
        int num1=100;
        int num2=0;
        int res=0;

        while (num1-num2>=0){
            num1-=num2;
            res++;
        }

        System.out.println("res = " + res);
    }
}
