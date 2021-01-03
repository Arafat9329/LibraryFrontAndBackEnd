package javaInterviewCoding.day02;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySortAscending {

    public static void main(String[] args) {
        int[] arr = {1, 9, 8, 7};
        int tamp=0;

        for (int j = 0; j <arr.length ; j++) {

            for (int i = 0; i <arr.length ; i++) {
                int tg=arr[j];
                if (tg<arr[i]){
                    tamp =tg;
                    tg=arr[i];
                    arr[i]=tamp;
                }
        }
    }

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    public static void SortingArrayAsc(int[] arr) {

        ArrayList<Integer> list = new ArrayList();

        for(int each: arr) {

            list.add(each);

        }

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.size(); j++) {

                if (list.get(i) < list.get(j)) {

                    Integer temp = list.get(i);

                    list.set(i, list.get(j));

                    list.set(j, temp);

                }

            }

        }

        for(int i=0; i < list.size(); i++) {

            arr[i] = list.get(i);

        }

    }
    public static void SortingArrayDesc(int[] arr) {

        for(int i=0; i<arr.length; i++){

            for(int j =0; j < arr.length;j++) {

                if(arr[i] > arr[j]){

                    int temp = arr[i];

                    arr[i] = arr[j];

                    arr[j] = temp;

                }

            }
        }

        System.out.println(Arrays.toString(arr));

    }

}
