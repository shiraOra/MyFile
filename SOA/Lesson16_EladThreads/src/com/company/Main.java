package com.company;

public class Main {

    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println("test"));
        t.setName("my thread");
        t.getName();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//אסור לקרוא לפונקציה start פעמים


        /*MyClass myClass = new MyClass();
        myClass.run();
        Runnable myRunnable = new MyClass();
        myRunnable.run();
        Runnable myRunnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
            }
        };
        Runnable myRunnable3 = ()-> System.out.println("run2");
        myRunnable3.run();*/


        /*Thread thread1 = new Thread(()->slowRunningFunction(1));
        thread1.start();
        Thread thread2 = new Thread(()->slowRunningFunction(2));
        thread2.start();*/


        /*Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread1 " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread1.start();
        //thread1.interrupt();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if(i==5)
                        try {
                            thread1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    System.out.println("thread2 " + i);
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread2.start();*/



        /*System.out.println("first call to slowRunningFunction:");
        slowRunningFunction(1);
        System.out.println("second call to slowRunningFunction:");
        slowRunningFunction(2);*/

        //System.out.println("done calling slowRunningFunction");


        /*MyThread myThread = new MyThread();
        myThread.start();*/


        int[] arr = {5, 2, 3, 6, 8, 4, 2, 4, 6};
        int num = 6;
        //search(arr, 6);
    }

    public static void TheRaceProblem() {

































































































































    }

    public static int slowRunningFunction(int x) {

        System.out.println("starting " + x);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100000000; j++) {
                if (j % 2 == 0)
                    sum++;
                else
                    sum--;
            }
        }
        System.out.println("done " + x);
        return sum;
    }

/*    public static void search(int[] arr, int num){

        boolean f = false;

        SearchThread.FoundListener listener = new SearchThread.FoundListener() {
            @Override
            public void found(int index) {
                if(!f) {
                    f = true;
                    System.out.println("found at " + index);
                }
           }
        };
        int n = arr.length-1;
        SearchThread searchThread1 =
                new SearchThread(arr, 0, n/2, num, listener);
        SearchThread searchThread2 =
                new SearchThread(arr, n/2+1, n, num, listener);
        searchThread1.start();
        searchThread2.start();
    }*/


}

class MyClass implements Runnable {

    @Override
    public void run() {
        System.out.println("running...");
    }
}
