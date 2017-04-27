package com.company;

/**
 * Created by hackeru on 2/6/2017.
 */
public class Dog extends Animal {

    public  void makeSound(){
        bark();

    }
    public  void bark(){
        System.out.println("wooffffffff wooffffffff");
    }


    public void goToSleep() {
        super.goToSleep();
        makeSound();
    }
}
