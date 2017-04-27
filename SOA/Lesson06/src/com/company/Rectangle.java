package com.company;

/**
 * Created by hackeru on 2/12/2017.
 */
// Local Inner class
//ההגדרה שוכנת בתוך מתודה רק כשהמתודה מופעלת המחלקה תתקיים
//אין הגיון להוסיף מתודות למחלקה אלא אם כן מפעילים אותם בתוך המתודה

public class Rectangle {
    int width,height;


    public Rectangle makeMeSquare(){
        class Square extends Rectangle{
            public Square(int side){
                this.width=side;
            }

            public int getSide(){
                return this.width;
            }

            @Override
            public String toString() {
                return "I am a square with side"+width;
            }
        }
        return new Square(width);
    }
    @Override
    public String toString() {
        return "I am a rectangle width: "+width+ " height: "+height;
    }
}
