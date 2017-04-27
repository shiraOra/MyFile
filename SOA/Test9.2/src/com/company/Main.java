package com.company;

import java.security.InvalidParameterException;
import java.util.InvalidPropertiesFormatException;
import java.util.Random;

public class Main {
    static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        // write your code here


        int []arr={500,3,100,101,9,90,102};
        int[][]arr2={{1,2,3,4,9},{2,6,8,18,20},{5,7,10,19,21},{6,8,20,40,41},{7,9,21,50,53}};
        quickSort(arr,0,arr.length-1);
        printArray(arr);
        System.out.println(tar1(arr,3));
        System.out.println(tar2(arr2,8));

    }
//אלגוריתם לתרגיל 1
    //1.מיין את המערך במיון אופטימלי
   //2. לולאה: עבור index i מהמקום הראשון עד המקום הM שלפני האחרון:
    //2.1 חשב את ההפרש בין האיבר במקום הi

    static int tar1(int[]arr,int m){
        if(m==0||arr.length==0)
            return 0;
        if(arr.length<m)
            return -1;
        quickSort(arr,0,arr.length-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-m+1;i++){
            if((arr[i+m-1]-arr[i])<min)
                min=arr[i+m-1]-arr[i];
        }
        return min;
    }

    static boolean tar2(int[][]arr,int x){

        if(x>arr[arr.length-1][arr.length-1])
            return false;
        for(int i=arr.length-2;i>=0;i--) {
            if (x > arr[i][i]) {
                for (int j = 0; j < i + 1; j++)
                    if (arr[i + 1][j] == x || arr[j][i + 1] == x)
                        return true;
            }

        }
return false;
    }



    //אלגוריתם לתרגיל 2
//1.התחל באיבר בפינה הימנית העליונה של המטריצה
//2. לולאה: השווה איבר זה עם X
//2.1 אם הם שויים אז החזר את המיקום
//2.2 אחרת אם האיבר קטן מ-X אז הזז את המיקום מטה(בדוק גלישה מגבולות המערך אם יש גלישה החזר שלא נמצא האיבר)
//2.3 אחרת אם האיבר גדול מ-X אז הזז את המיקום שמאלה(שוב בדוק גלישה...)
//חזור על שלבים אילו עד אשר נמצא האיבר או שמוחזר שלא נמצא האיבר.

    static boolean tar2Teacher(int [][]mat,int x){
        int n=mat.length;
        int i=0,j=n-1;//set the inddex to the top right element
        while(i<n&&j>=0){
            if(mat[i].length!=n)
                throw new InvalidParameterException("row"+i+"is not length"+n);
            if(mat[i][j]==x)
                return true;
            if (mat[i][j]>x)
                j--;
            else
                i++;
        }
        return false;

    }

   /* static boolean tar2Plus(int[][]arr,int x) {
        if (x < arr[0][0])
            return false;
        else
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i][i] > x) {
                    for (int j = 0; j < arr.length; j++) {
                            if(arr[i][j]==x||arr[j][i]==0)
                                return true;
                    }
                }
            }
    }*/
    static int randomizedPartition(int[] arr, int low, int high) {
        if (high == low)
            return low;
        int pos = random.nextInt(high - low) + low;
        int temp = arr[high];
        arr[high] = arr[pos];
        arr[pos] = temp;
        return partition(arr, low, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static void printArray(int[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i<arr.length-1)
                System.out.print(",");
        }
        System.out.println("}");
    }



}

