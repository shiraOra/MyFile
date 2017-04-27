package com.company;

public class Main {

    /*
    * בזמן ריצה מה שקורה זה מה שיש בפועל-הערך האמיתי
    * בזמן קומפילציה הוא בודק עפ"י המצביע
    * Dog d=new Poodle();
    * המצביע הוא Dog והערך האמיתי הוא Poodle*/

    //Virtual method

    public static void main(String[] args) {
	// write your code here

        // Call the func of Poodle- print booffffffffff
        Poodle p1= new Poodle();
        p1.makeSound();

        // Call the func of Poodle- print booffffffffff
        Dog p2=new Poodle();
        p2.makeSound();
        p2.goToSleep();

        // Call the func of Dog- print wooffffffff wooffffffff
        Dog p3=new Dog();
        p3.makeSound();
        p3.bark();
        p3.goToSleep();


        Animal p4=new Poodle();
        Poodle p5=(Poodle) p3;

       if(p4 instanceof Poodle)
           ((Poodle) p4).roll();



        //למרות שתכלס' p4 הוא מסוג poodle מכיון שהמצביע שלו מטיפוס Animal הוא לא מכיר את הפונקציה bark
        //p4.bark();
    }
}
