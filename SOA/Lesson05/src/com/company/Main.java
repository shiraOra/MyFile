package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Point p1=new Point(5,3);
        Point p2=p1;
        Point p3=new Point(5,3);
        System.out.println(p3.equals(p1));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        System.out.println(Point.getCounter());
    }






}
