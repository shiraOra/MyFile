package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(fib(89));
    }

    static int distance(int x, int y) {

        int result=0;
        int small=x;
        int large=y;
        if(small>large) {
            small = y;
            large=x;
        }
        while (small+result<large)
            result++;
        return result ;
    }
    static int product(int x, int y){
        int result=0;
        int small=x;
        int large=y;
        if(small>large)
            small = y;
            large=x;
        for(int i=0;i<small;i++)
            result+=large;
        return result;
    }


    static int quotient(int x, int y) {
        if(y==0)
            return -1;
        int result = 0;
        int sum=y;
        while (sum<=x){
            sum+=y;
            result++;
        }
        return result;
    }

    static int remainder(int x, int y){
        if (y==0) return -1;
        return distance(x,product(quotient(x, y),y))  ;
    }

    static int power1(int x, int y) {
        if (x == 0) {
            if (y == 0)
                return -1;
            return 0;
        }
        if (x == 1||y==0)
            return 1;
        int result = x;
        for (int i = 1; i < y; i++)
            result *= x;
        return result;
    }

    static int power2(int x, int y) {

        if (x == 0) {
            if (y == 0)
                return -1;
            return 0;
        }
        if (x == 1||y==0)
            return 1;
        return x*power2(x,y-1);
    }


    static int square(int x) {
        int i = 0;
        int result = 0;
        while ((i * i) < x)
            i++;
        return i;
    }
//---------------------------------------------------

    static int product2(int x, int y) {
        int result = 0;
        while (y > 0) {
            if (y % 2 == 0) {
                y = y >> 1;
                x = x << 1;
            } else {
                y--;
                result += x;
            }
        }
        return result;

    }
    static int power(int x, int y)
    {
        if(x==0){
            if (y==0)
                return -1;
            return 0;
        }
        if(y==0||x==1)
            return 1;
        if(y%2==0){
            int temp=power(x,y/2);
            return temp*temp;

        }
        else {
            int temp= power(x,(y-1)/2);
            return temp*temp*x;
        }
    }


    static int fib(int n)
    {
        if (n==1||n==2)
            return 1;
        int a=0, b=1,c;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
        //return fib(n-1)+fib(n-2);
    }

}