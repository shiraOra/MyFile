package com.company;

import java.util.Arrays;

/**
 * Created by hackeru on 2/27/2017.
 */

public class MyString implements Comparable<MyString> {
    public char[] getArr() {
        return arr;
    }

    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 23, 37};
    private final char[] arr;

    public MyString(char[] arrt) {
        char[] temp = new char[arrt.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arrt[i];
        }
        arr = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public MyString toUpper() {
        char[] temp = new char[this.arr.length];
        for (int i = 0; i < this.arr.length; i++)
            temp[i] = arr[i] < 91 && arr[i] > 64 ? arr[i] : (char) (arr[i] - 32);
        return new MyString(temp);
    }

    public int indexOf(MyString balonzo) {
        int k, j = 0;
        for (int i = 0; i < this.arr.length; i++) {
            k = i;
            while (arr[k++] == balonzo.arr[j++] && k < this.arr.length && j < balonzo.arr.length) ;
            if (j == balonzo.arr.length)
                return i;
            j = 0;
        }
        return -1;
    }

    public MyString[] split(char delimiter) {
        int delCounter = 1;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == delimiter)
                delCounter++;
        }
        MyString[] result = new MyString[delCounter];
        if (delCounter == 1) {
            result[0] = new MyString(this.arr);
            return result;
        }
        char[] temp = new char[arr.length];
        int tempCounter = 0, resCounter = 0;
        for (int i = 0; i < this.arr.length; i++) {
            while (i < arr.length && this.arr[i] != delimiter) {
                temp[tempCounter] = this.arr[i];
                tempCounter++;
                i++;
            }
            result[resCounter++] = new MyString(temp);
            for (int l = 0; l < temp.length; l++)
                temp[l] = ' ';
            tempCounter = 0; // for the next time
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyString) {
            MyString c = (MyString) obj;
            if (c.arr.length != this.arr.length)
                return false;
            for (int i = 0; i < arr.length; i++) {
                if (c.arr[i] != arr[i])
                    return false;
            }
            return true;
        }
        return false;
    }




    @Override
    public int compareTo(MyString o) {
        if (o.getArr().length > this.arr.length)
            return -1;
        if (o.getArr().length < this.arr.length)
            return 1;
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] > o.arr[i])
                return 1;
            if (arr[i] > o.arr[i])
                return -1;
        }
        return 0;
    }

    /*  @Override
    public int hashCode() {
        int superCode = 1;
        for (int i = 0; i < this.arr.length; i++)
            superCode ^= primes[i] * arr[i];
        return superCode;
    }*/


    @Override
    public int hashCode() {
        int n = arr.length - 1;

        byte a = (byte) arr[0];

        byte b = (byte) arr[n/4];
        byte c = (byte) arr[3*n/4];
        byte d = (byte) arr[n];

        int hash = 0;
        hash |= (a & 0xFF);
        hash <<= 8;
        hash |= (b & 0xFF);
        hash <<= 8;
        hash |= (c & 0xFF);
        hash <<= 8;
        hash |= (d & 0xFF);

        return hash;

    }
}