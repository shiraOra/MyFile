package com.company;

/**
 * Created by hackeru on 2/8/2017.
 */
public class Point {

    private static int counter;
    private int x;
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

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        counter++;
    }
    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Point.counter = counter;
    }

    //
    @Override
    public String toString() {
        return ("("+x+","+y+")");
    }


    //object equals is check the address of the objects.
    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
        if(obj==this)
            return true;
        if (obj instanceof Point){
            Point other =(Point)obj;
            return this.x==other.x && this.y==other.y;
        }
        return false;
        // When method "equals" is called by an Object with null value there is an Exception.
        //However when we check it with the operator '==' ,it can check it. // p1=null, p2=null
        //if(p1.equals(p2) -> Exception
        //if(p1==p2) ->true

    }

    @Override

    //מזהה של המחלקה Point
        public int hashCode() {
        return (7*x)^(11*y)^(53*y);
    }
}
