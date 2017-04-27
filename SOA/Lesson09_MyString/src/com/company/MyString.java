package com.company;

import java.util.Arrays;

public class MyString {

    final char[] charsArr;


    public MyString(char[] arrt) {
        char[] temp=new char[arrt.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=arrt[i];
        }
        charsArr=temp;
    }

    public int indexOf(MyString myString){
        int index,i=0,j;
        while (i<this.charsArr.length){
            index=-1;
            for ( j = 0; j <myString.charsArr.length ; j++) {
                if (this.charsArr[i]==myString.charsArr[j]){
                    if(index==-1)
                        index=i;
                    i++;
                }
                else
                    break;
            }
            if(j==myString.charsArr.length)
                return index;
            i++;
        }

        return -1;
    }

    public MyString[] sentenceToWords(char c){
        int countC=0;
        for (int i = 0; i <this.charsArr.length ; i++) {
            if (this.charsArr[i]==c)
                countC++;
        }
        MyString[] myStrings=new MyString[countC+1];
        char[] myString=new char[10];
        int j=0;
        int k=0;
        for (int i = 0; i <this.charsArr.length ; i++) {
            if (this.charsArr[i]!=c){
                myString[j]=this.charsArr[i];
                j++;
            }
            else{
                if (j!=0){
                    myStrings[k]=new MyString(myString);
                    k++;
                    myString=new char[10];
                    j=0;
                }
            }
        }
        myStrings[k]=new MyString(myString);
        return myStrings;
    }
    public void printMyString (){
        for (int i = 0; i <this.charsArr.length ; i++) {
            System.out.print(charsArr[i]);
        }

    }
    public void toUpper (){
        for (int i = 0; i <this.charsArr.length ; i++)
            if (charsArr[i]>=97&&charsArr[i]<=122)
                charsArr[i]= (char) (charsArr[i]-32);


    }

    @Override
    public String toString() {
        return Arrays.toString(charsArr);
    }
}
