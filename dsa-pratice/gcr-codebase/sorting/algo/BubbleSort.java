package sorting.algo;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=new Random().nextInt(-100,100);
        }
        System.out.println("this is array before sorting:"+ Arrays.toString(arr));

        //sorting using recusion
        for (int i = 0; i < 10; i++) {
            sortMethod(arr,i);
        }
        System.out.println("this is array after sorting:"+ Arrays.toString(arr));
    }

    private static int sortMethod(int[] arr, int start) {
        if(start== arr.length-1) return arr[start];

        int first=arr[start];
        int second=sortMethod(arr, start+1);
        if (first>second) swap(arr,start,start+1);
        return Math.min(first,second);

    }


    public static void swap(int[] arr,int first, int second){
        int tem=arr[first];
        arr[first]=arr[second];
        arr[second]=tem;
    }
}
