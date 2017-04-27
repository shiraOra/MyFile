package com.company;

/**
 * Created by hackeru on 2/12/2017.
 */
public class Circle {

    private Point center;
    private int radias;
    private int z;

    public Circle(){
        this(0,0,0);
    }
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadias() {
        return radias;
    }

    public void setRadias(int radias) {
        this.radias = radias;
    }

    public Circle(int x, int y, int r) {
        this.center = this.new Point(x,y);
        this.radias = r;

    }
    public int area(){
        return 10;
    }

    //Inner class
    //המחלקה משויכת לאוביקט
    //מתוך המחלקה ניתן להתיחס לאוביקט המכיל אותה

    public class Point{
        private int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

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

        public int getZ(){
            return Circle.this.z;
        }

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
