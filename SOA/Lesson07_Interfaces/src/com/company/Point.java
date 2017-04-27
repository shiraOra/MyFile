package com.company;

import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/13/2017.
 */
public class Point implements Comparable{

    private int x;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public int compareTo(Object o) {
    /*if (o==null|| !(o instanceof Point))
        throw new InvalidParameterException();
    if(o==this)*/
        return 0;
/*    Point other=(Point)o;
    double d1=this.distanceFromOrigin();
    double d2=other.distanceFromOrigin();
    if(d1>d2)
        return 1;
    else if(d1<d2)
        return -1;
    if(this.x>=0){
        if(other.x>=0){
            if(this.y>=0&&other.y>=0){
                if(this.y>=other.y)
                    return 1;
                else
                    return -1;
            } else {
                if (this.y<0)
                    return 1;
                else return -1;
            }else {
                if (this.y>=0)
                    return -1;
                else
            }

        }
    }*/


    }
    static void bubbleSort(Comparable[] arr){
        int upTo = arr.length-1;
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < upTo; i++) {
                if(arr[i].compareTo( arr[i+1])>0){
                    Comparable temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
            upTo--;
        }
    }
public double distanceFromOrigin(){
        return Math.sqrt(x*x+y*y);
}

    }
