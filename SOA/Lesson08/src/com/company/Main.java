package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

    public static final int ASCII_9 = 57;
    public static final int ASCII_0 = 48;
    public static final int ASCII_MINUS = 45;

    public static void main(String[] args) {
        // raw type
        LinkedList<Dog> linkedList = new LinkedList<Dog>();
        linkedList.add(new Dog());
        // linkedList.add(new Cat());
        LinkedList<Animal> animals = new LinkedList<Animal>();
        LinkedList animals2 = animals;
        LinkedList<Animal> animals3 = animals2;

        //list2.add(new Dog());
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Animal());
        List<?> list2 = animals;// ניתן לקרוא למתודות שמשנות את הנתונים אבל לא למתודות שמשנות את הנתונים
        System.out.println(list2.get(1));
        LinkedList<Dog> dogs = new LinkedList<>();
        //Cat and Animal can't cast to Dog
     /*   for (int i = 0; i <animals.size() ; i++) {
            dogs.add((Dog) animals.get(i));
        }*/
        Pair<Dog, Cat> pair = new Pair<>(new Dog(), new Cat());
        Dog d = pair.getObject1();
        Cat c = pair.getObject2();
        List list = new LinkedList();
        list.add("Shira");
        list.add("Ora");
        list.add(new Dog());//Thrown exception because list is cast to string but this object is Dog
        list.add("Zadok");
        List<String> strings = list;
        // strings.add(new Dog()); //Although list is an object's list, the pointer is string and a Dog can't be add to the list
        String s1 = strings.get(3);
        System.out.println(s1);
        fill(dogs, 7, new Dog());
        //LinkedList<Animal> animals2=new LinkedList<Dog>();
        LinkedList<Animal> animals4 = new LinkedList<Animal>();
        LinkedList<Dog> dogs2 = new LinkedList<>();
        for (int i = 0; i < animals4.size(); i++) {
            dogs.add((Dog) animals4.get(i));
        }
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter your name");
//        try {
////            String name=bufferedReader.readLine();
////            System.out.println("Your name is "+name);
//            String ageAsString=bufferedReader.readLine();
//            int age=Integer.valueOf(ageAsString);
//            System.out.println("Your age is  "+age );
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("error reading");
//        } catch (NumberFormatException exception){
//            System.out.println("must enter an integer");
//        }
        System.out.println("Enter a number");

        String s = null;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] sBytes = s.getBytes();
        char c1 = (char) (sBytes[0]);
//        System.out.println(sBytes[0]);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(toInt(s));
    }

/*public static boolean isInt(String  num){
    if (num==null||num.length()==0)
        return false;
    byte[] numBytes=num.getBytes();
    int numBytesLength=numBytes.length;
    for (int i = 0; i <numBytesLength; i++) {
        if(numBytes[i]< ASCII_0 ||numBytes[i]> ASCII_9)
            return false;
    }
    return true;
}

public static int toInt(String  s) {
    int num = 0, temp;
//    if(!isInt(s))
//        return -1;
    byte[] sBytes = s.getBytes();
    int sBytesLength = sBytes.length;
    for (int i = 0; i < sBytesLength; i++) {
        num = num * 10 + ((int) sBytes[i] - ASCII_0);
    }
    return num;
}*/

    public static boolean isInt(String num) {
        if (num == null || num.length() == 0)
            return false;
        byte[] numBytes = num.getBytes();
        if ((numBytes[0] < ASCII_0 && numBytes[0] != ASCII_MINUS) || numBytes[0] > ASCII_9)
            return false;
        int numBytesLength = numBytes.length;
        for (int i = 1; i < numBytesLength; i++) {
            if (numBytes[i] < ASCII_0 || numBytes[i] > ASCII_9)
                return false;
        }
        return true;
    }

    public static int toInt(String s) {
        int num = 0, i = 0;
        boolean isNegetive = false;
//        if (!isInt(s))
//            return -1;
        byte[] sBytes = s.getBytes();
        if (sBytes[i] == ASCII_MINUS) {
            i++;
            isNegetive = true;
        }
        int sBytesLength = sBytes.length;
        for (; i < sBytesLength; i++) {
            num = num * 10 + ((int) sBytes[i] - ASCII_0);
        }
        if (isNegetive)
            num *= -1;
        return num;
    }

    public static <T> void fill(List<T> list, int quantity, T obj) {
        for (int i = 0; i < quantity; i++) {
            list.add(obj);
        }

    }


}

class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}
/*
* אחרי שמכניס סיסמא צריך להכניס את הסיסמא שוב -אימות סיסמא
*
*
* */