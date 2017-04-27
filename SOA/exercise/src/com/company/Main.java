package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int arr[]={9};
        System.out.println(sum(arr));
    }

    public static int sum(int []arr) {
        int sum = 0;
        int n = arr.length;
//        sum+=arr[0]*arr.length;
//        sum+=arr[arr.length-1]*arr.length;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i] * (n - i) * (1 + i);
        return sum;
    }

    public static int sumN3(int []arr){
        return 0;
    }
}


