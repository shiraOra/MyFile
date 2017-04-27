package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int arr[] = {1,5};
       System.out.println(ex1_1(arr));
        System.out.println(ex1_2(arr));
       /* ex2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
    }

    public static boolean ex1_1(int[] arr) {
        boolean isDown = true;
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] >=arr[i + 1])
                break;
        }
        if (i == arr.length)
            return true;
        for (; i < arr.length - 1 && isDown; i++) {
            if (arr[i] <=arr[i + 1])
                isDown = false;
        }
        if (!isDown)
            return false;
        return true;
    }

    public static int ex1_2(int[] arr){
       return ex1_2(arr,0,arr.length-1);
    }

    public static int ex1_2(int []arr,int left,int right){
        if(right==0)
            return left;
        if (left==arr.length-1)
            return right;
        int middle=left+(right-left)/2;
        if (middle==0)
            return middle;
        if(arr[middle-1]<arr[middle]&&arr[middle+1]<arr[middle])
            return middle;
        else
            if(arr[middle-1]>arr[middle])
                return ex1_2(arr,left,middle-1);
        return ex1_2(arr,middle+1,right);
    }



    public static void ex2(int[] arr) {
        int temp;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 != 0) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            } else {
                i++;
            }

        }
    }


    static int findPeak (int[] arr, int from, int to){
        if(from==to)
            return from;
        if(to-from==1)
            return arr[from]>arr[to]?from:to;
        int middle=from+(to-from)/2;
        boolean greaterThanMyLeft=arr[middle]>arr[middle-1];
        boolean greaterThanMyRight=arr[middle]>arr[middle+1];
        if(greaterThanMyLeft && greaterThanMyRight)
            return middle;
        if(greaterThanMyLeft && !greaterThanMyRight)
            return findPeak(arr, middle+1,to);
        return findPeak(arr,from,middle-1);
    }

    public static void train(){

    }

}