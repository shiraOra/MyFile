package com.company;

import java.math.BigDecimal;
//Q10
//import static abc.org.project.a.MYCONST;


public class Main extends base1 implements base2{

    public static void main(String[] args) {
        // write your code here

        //Q1
     /*   int i=012;
        if(i==10.0)
            System.out.println("true");*/

        //Q2

      /*  Number [] numbers = new Number[4];
        numbers[0] = new Number(0); // NUM
        numbers[1] = new Integer(1);
        numbers[2] = new Float(2.0f);
        numbers[3] = new BigDecimal(3.0); // BIG
        for(Number num : numbers) {
            System.out.print(num + " ");
        }*/

        //Q3
      /*  StringBuffer strBuffer = new StringBuffer("This, that, etc.!");
        System.out.println(strBuffer.replace(12, 15, "etcetera"));*/

        //Q4
      /*  Object nullObj = null;
        StringBuffer strBuffer = new StringBuffer(10);
        strBuffer.append("hello ");
        strBuffer.append("world ");
        strBuffer.append(nullObj);
        strBuffer.insert(11, '!');
        System.out.println(strBuffer);*/

        //Q5
     /*   Boolean b = null;
        System.out.println(b ? true : false);*/

        //Q6
      /*  Derived b = new DeriDerived();*/

      //Q13
        /*Base obj = new Base1();
        ((Base2)obj).test();*/
        //Q14
       /* Outer.Inner inner = new Outer().new Inner();
        inner.print();*/

       //Q18
       // System.out.println("var:" + var);
        System.out.printf();
    }


    }
    //Q6
    /*class Base {
        public Base() {
            System.out.println("Base");
        }
    }
    class Derived extends Base {
        public Derived() {
            System.out.println("Derived");
        }
    }
    class DeriDerived extends Derived {
        public DeriDerived() {
            System.out.println("DeriDerived");
        }


}*/
//Q13
/*
class Base {
    public void test() {}
}
class Base1 extends Base {
    public void test() {
        System.out.println("Base1");
    }
}
class Base2 extends Base {
    public void test() {
        System.out.println("Base2");
    }
}
*/

//Q14
/*class Outer {
    class Inner {
        public void print() {
            System.out.println("Inner: print");
        }
    }
}*/

//Q18
class base1 {
    protected int var;
}
interface base2 {
    int var = 0; // #1
}


