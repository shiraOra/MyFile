package com.company;

/**
 * Created by eladlavi on 22/02/2017.
 */
public class Queue<T> {
    T arr;
    int front, rear, size;

    public Queue() {
        arr = (T[])new Object[5];
        front = 0;
        rear = arr.length-1;
        size = 0;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == arr.length;
    }

    public void insert(int x){
        if(isFull())
            throw new IndexOutOfBoundsException();
        rear = (rear + 1) % arr.length;
        arr[rear] = x;
        size++;
    }

    public int pop(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        int x = arr[front];
        front = (front + 1)%arr.length;
        size--;
        return x;
    }

    public int front(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return arr[front];
    }

    public int rear(){
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return arr[rear];
    }


}