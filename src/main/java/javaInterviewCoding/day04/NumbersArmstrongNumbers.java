package javaInterviewCoding.day04;

public class NumbersArmstrongNumbers {
    public static void main(String[] args) {

        System.out.println("ArmStrongNumber(1634) = " + ArmStrongNumber(1634));

    }

    public  static  boolean ArmStrongNumber (int  num) {

        int a = 0,    b =0,    c= num;

        while(num>0){

            a=num%10;

            num/=10;
            System.out.println("a = " + a);
           b=b+(a*a*a);
            System.out.println("b = " + b);

        }

        if(c==b) {

            return true;

        }

        return false;

    }

    public static boolean isArmstrong(int num) {

        int sum = 0;
        int numClone = num;
        int power = 0;
        int tempBase;

        while (numClone > 0 ){
            numClone = numClone/10;
            power++;
        }

        numClone = num;

        while(numClone > 0){

            tempBase = numClone%10;
            sum += Math.pow(tempBase, power);
            numClone/=10;
        }

        return sum == num ;
    }
}
