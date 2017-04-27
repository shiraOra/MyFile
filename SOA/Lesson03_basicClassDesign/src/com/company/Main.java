package com.company;

import graficshape.Circle;
import graficshape.Point3D;

public class Main {

    public static void main(String[] args) {
// write your code here
//        HappyBirthday.wish("Shira");
//        Circle c=new Circle();
//        c.setRadias(5);
//        Point3D p3d=new Point3D(3,4,4);
//        System.out.println(p3d);
//  //      System.out.println(add(1,2));
//        System.out.println(sumOfDigit(456));
        System.out.println(LargestDigit(123456789));


    }
/*public static long add(long l1,long l2){
        return l1+l2;
}*/

static boolean divisibleBy7(int num){
    if(num<0)
        return divisibleBy7(-num);
    if(num==0||num==7)
        return true;
    if (num<10)
        return false;
    return divisibleBy7(num/10-2*(num-num/10*10));
}
    static int sumOfDigit(int num){
    if(num<10)
        return num;
    return num%10+sumOfDigit(num/10);

    }
    static int LargestDigit(int num){
    int max=0;
       while (num>0) {
           if(num%10>max)
            max=num%10;
           num /= 10;
       }
       return max;
    }
   static int reverseDigit(int num){
      int sum=0;
       while (num>0) {
           sum = sum * 10 + num % 10;
           num /= 10;
       }
       return sum;
    }

    static boolean divisibleBy3(int num){
        int n=sumOfDigit(num);
        if(n>9)
           return divisibleBy3(sumOfDigit(n));
        else
            return(n==9||n==6||n==3||n==0);

    }
    static int finalSumOfDigit(int num){
        int result=0;
        while (result>=10)
            result=finalSumOfDigit(result);
        return result;
    }
}


