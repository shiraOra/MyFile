package com.company;

/**
 * Created by hackeru on 2/8/2017.
 */
public class Segment {
    private Point p1;
    private Point p2;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return p1+"-"+p2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
        if (obj==this)
            return true;
        if(obj instanceof Segment){
            Segment other=(Segment) obj;
           // return (this.p1==other.p1&&this.p2==other.p2)||(this.p1==other.p2&&this.p2==other.p1);
            return (this.p1.equals(other.p1)&&this.p2.equals(other.p2))||(this.p1.equals(other.p2)&&this.p2.equals(other.p1));
        }
            return false;
    }
}
