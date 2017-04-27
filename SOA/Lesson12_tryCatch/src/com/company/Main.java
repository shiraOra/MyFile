package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            int[] arr = new int[3];
            arr[15] = 90;
            Animal c = new Cat();
            System.out.println("end of try");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("there was an error");
            System.out.println(ex.getMessage());
        } catch (ClassCastException ex) {
            System.out.println("there is a casting error");
        } finally {
            System.out.println("in finally");
        }

        //מה שנצא בתוך ה finally מתבצע תמיד גם אם יש return
        //משתמשים בזה בדרכך כלל כדי לשחרר משאבים

        System.out.println("done");

        try {
            myExeption();
        } catch (MyExeption myExeption) {
            myExeption.printStackTrace();
        }
    }
    public static void myExeption() throws MyExeption {
        throw new MyExeption(8);
    }
}



 class Animal {}

class Cat extends Animal{}

class Dog extends Animal{}


class MyExeption extends Exception{
    private int image;

    public MyExeption(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}