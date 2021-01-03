package javaInterviewCoding.day04;

public class NumbersFactorialNumber {

    public static void main(String [] age){
        int num =17;

        long sum=1;
        for (int i = 1; i <=num ; i++) {
            sum*=i;
        }

        System.out.println("sum = " + sum);
    }
}
