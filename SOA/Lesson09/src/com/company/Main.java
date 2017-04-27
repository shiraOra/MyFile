package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

	Station[]stations={
	        new Station(2,3),
            new Station(2,3),
            new Station(3,1)
    };
        System.out.println(findStartingStation(stations));

    }

    public static int findStartingStation(Station[]stations){
        for (int i = 0; i <stations.length ; i++) {
            boolean validPath=true;
            int sum=0;
            int j=i;
            do{
                sum+=stations[j].charge;
                sum-=stations[j].distanceToNext;
                if(sum<0) {
                    validPath = false;
                    break;//while
                }
                j++;
                if (j==stations.length)
                    j=0;
            }while (j!=i);
            if(validPath)
                return i;
        }
        return -1;
    }

    public static int findStartingStation2(Queue<stations){


    }

}



class Station{
    public Station(int charge, int distanceToNext) {
        this.distanceToNext = distanceToNext;
        this.charge = charge;
    }
    int charge;
    int distanceToNext;

}