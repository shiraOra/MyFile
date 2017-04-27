package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int[] findKNumbers(int [] arr,int k){
        int [] newArr=new int[k];
        int end=0;
        for(int i=0;i<arr.length;i++){
            if(i<k){
                if(i==0)newArr[0]=arr[i];
                else {
                    if (arr[i] > newArr[end]){
                        newArr[end+1]=arr[i];
                    }
                    else
                        for (int j = 0; j < end; j++) {
                            //if(newArr[j]>arr[i])
                        }
                }
                    end++;
            }

            else {
                if(arr[i]<newArr[k-1]) {
                    for (int j = 0; j < k - 1; j++)
                        if (newArr[j] > arr[i]) {
                            for (int l = k - 1; l > j; l--) {
                                newArr[l] = newArr[l - 1];
                            }
                            newArr[j] = arr[i];
                        }
                }
                }
        }
    }


}
