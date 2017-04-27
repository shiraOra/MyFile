package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,String>users=new HashMap<>();
        String userName="Shira";
        String password="Arusi";
        MyInteger myInteger=new MyInteger();


        MyThread myThread1=new MyThread(users,userName,password,myInteger);
        MyThread myThread2=new MyThread(users,userName,password,myInteger);

        /*myThread1.start();
        myThread2.start();*/

       /* AtomicInteger atomicInteger=new AtomicInteger(0);
        int x= atomicInteger.incrementAndGet();
        atomicInteger.compareAndSet(5,8);*/

        //Semaphore

/*        Semaphore machine=new Semaphore(2);
        PersionThread persionThread1=new PersionThread(machine,"Hadasa");
        PersionThread persionThread2=new PersionThread(machine,"Sarah");
        PersionThread persionThread3=new PersionThread(machine,"Noa");
        PersionThread persionThread4=new PersionThread (machine,"Sari");
        PersionThread persionThread5=new PersionThread(machine,"Shira");
        PersionThread persionThread6=new PersionThread(machine,"Malki");
        persionThread1.start();
        persionThread2.start();
        persionThread3.start();
        persionThread4.start();
        persionThread5.start();
        persionThread6.start();*/

        //CountDownLatch

       /* CountDownLatch counter=new CountDownLatch(5);
        new RunnerThread(counter,"Hadasa");
        new RunnerThread(counter,"Sarah");
        new RunnerThread(counter,"Shira");
        new RunnerThread(counter,"Noa");
        new RunnerThread(counter,"Maayan");
        System.out.println("Starting the countdown");
        long countValue=counter.getCount();
        while (countValue>0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(countValue);
            if(countValue==1){
                System.out.println("start");
            }
            counter.countDown();
            countValue=counter.getCount();
        }*/

       //Exchanger

      /* Exchanger<String> talk=new Exchanger<>();
       new FirstThread(talk).start();
       new SecondThread(talk).start()*/;


        //CyclicBarrier

        System.out.println("As soon four players arrive game is start.");
        CyclicBarrier barrier=new CyclicBarrier(4,new MixedDoubleTennisGame());
        new Player(barrier,"Sari").start();
        new Player(barrier,"Malki").start();
        new Player(barrier,"Sapir").start();
        new Player(barrier,"Zofiya").start();

    }
}
class MyInteger{
    int x;
}

class PersionThread extends Thread{
    private Semaphore machines;
    private String name;

    public PersionThread(Semaphore machines, String name) {
        this.machines = machines;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" waing to access ATM machine");
        try {
            machines.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+" is accessing the ATM machine");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name+" is done using the ATM machine");

    }
}

class RunnerThread extends Thread{
    private CountDownLatch timer;
    private String name;

    public RunnerThread(CountDownLatch timer, String name) {
        this.timer = timer;
        this.name = name;
        System.out.println(name+ " ready and waiting for the count down to start" );
        start();
    }

    @Override
    public void run() {
        try {
            timer.await();
        } catch (InterruptedException e) {
            System.out.println("interrupted-can't start running the race");
        }
        System.out.println(name+" started running");
    }
}

class FirstThread extends Thread{
    private Exchanger<String> talk;

    public FirstThread(Exchanger<String> talk) {
        this.talk = talk;
    }

    @Override
    public void run() {
        String reply=null;
        try {
            //start conversation
            reply=talk.exchange("knock knock");
            // print the second thread reply
            System.out.println("SecondThread: "+reply);
            reply=talk.exchange("FirstThread ");
            System.out.println("SecondThread: "+reply);
            reply=talk.exchange("FirstThread that was here before you ");
            System.out.println("SecondThread: "+reply);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SecondThread extends Thread{
    private Exchanger<String> talk;

    public SecondThread(Exchanger<String> talk) {
        this.talk = talk;
    }

    @Override
    public void run() {
        String reply=null;
        try {
            Thread.sleep(5);
            //exchange the first message
            reply=talk.exchange("who's there");
            //print the first response
            System.out.println("FirstThread:"+reply);
            reply=talk.exchange("FirstThread who?");
            System.out.println("FirstThread:"+reply);
            reply=talk.exchange("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MixedDoubleTennisGame extends Thread{
    @Override
    public void run() {
        System.out.println("all 4 players are ready game is start");
    }
}


class Player extends Thread{
    CyclicBarrier waitPoint;
    private String name;

    public Player(CyclicBarrier waitPoint, String name) {
        this.waitPoint = waitPoint;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Player: "+name+"is ready");
        try {
            waitPoint.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}




