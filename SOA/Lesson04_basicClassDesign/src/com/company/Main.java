package com.company;


import myPackage.MyClass;
import static java.lang.Math.PI;
import static java.lang.Math.*;
public class Main {

    public static void main(String[] args) {

        MyClass mC=new MyClass();
        double p=1,e=1;
        p*=PI;
        e*=E;


        //region printNull


        Segment segment=new Segment(new Point(4,5),null);
//        System.out.println(segment);
        Point p1=new Point(1,2);
        segment.setP1(p1);
        p1.setX(13);
//        System.out.println(segment);
//        Dog d1=null;
//        Dog d2=new Dog();
        Point p2=new Point(1,2);

        if (p1.equals(p2))
            System.out.println("p1==p2");
        else
            System.out.println("p1!=p2");



//        System.out.println(d1);
//        System.out.println(d2);
        ;
        //endregion

        // write your code here
    }
    static class Dog{
        void bark(){
            System.out.println("Waffff");
        }

        @Override
        public String toString() {
            return "I am a dog";
        }
    }
}
