package com.company;

public class Main {

    public static void main(String[] args) {

        // write your code here
        Thread thread1=new Thread(()->slowRunningFunction(1));
        thread1.start();
        Thread thread2=new Thread(()->slowRunningFunction(2));
        thread2.start();
      /*  int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("first loop: " + i);
            for (int j = 0; j < 1000000000; j++) {
                if (j % 2 == 0)
                    sum++;
                else
                    sum--;
            }
        }*/
        System.out.println("End of main");
    }




    public static int slowRunningFunction(int x){
        int sum=0;
        System.out.println("starting "+x);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000000000; j++) {
                if(j % 2 == 0)
                    sum++;
                else
                    sum--;
            }
        }
        System.out.println("done "+x);
        return sum;
    }
}
