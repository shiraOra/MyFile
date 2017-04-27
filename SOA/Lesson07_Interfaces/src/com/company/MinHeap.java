package com.company;

/**
 * Created by eladlavi on 15/02/2017.
 */
public class MinHeap extends Heap {
    public MinHeap() {
        super(false);
    }

    public MinHeap(int[] arr){
        super(arr, false);
    }

    public int getMax(){
        return getTop();
    }

    public int extractMax(){
        return extractTop();
    }
}