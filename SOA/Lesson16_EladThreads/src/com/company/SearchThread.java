package com.company;

/**
 * Created by eladlavi on 06/03/2017.
 */
public class SearchThread extends Thread {

    private int[] arr;
    private int from, to;
    private int num;
    private FoundListener listener;

    public SearchThread(int[] arr, int from, int to, int num, FoundListener listener) {
        this.arr = arr;
        this.from = from;
        this.to = to;
        this.num = num;
        this.listener = listener;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            if(arr[i] == num){
                if(listener != null)
                    listener.found(i);
                break;
            }
        }
    }

    public interface FoundListener{
        void found(int index);
    }
}