package javaInterviewCoding.day04;

public class NumbersPrimeNumber {

    public static boolean primeNumber(int num) {
        if(num < 2) return false;

        for(int i = 2; i < num; i++) {

            if(num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
