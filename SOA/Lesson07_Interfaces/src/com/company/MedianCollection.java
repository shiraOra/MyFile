package com.company;

/**
 * Created by hackeru on 2/15/2017.
 */
public class MedianCollection {
    private MinHeap minHeap;
    private MaxHeap maxHeap;

    public MedianCollection(MinHeap minHeap, MaxHeap maxHeap) {
        this.minHeap = minHeap;
        this.maxHeap = maxHeap;
    }
    public int getMedian(){
        if (minHeap.getSize()==0)
            throw new IndexOutOfBoundsException("Collection is empty");
        return maxHeap.getMax();
    }
    public void insert(int num){
        maxHeap.insert(num);
        if (maxHeap.getMax()>minHeap.getMin()){
            minHeap.insert(maxHeap.extractMax());
            maxHeap.insert(minHeap.extractMax());
        }
        if (maxHeap.getSize()-minHeap.getSize()==2)
            minHeap.insert(maxHeap.extractMax());
    }

}
