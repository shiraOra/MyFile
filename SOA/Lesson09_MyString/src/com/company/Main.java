package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyString myString=new MyString(new char[]{'H','e','l','l','o',' ','S','a','r','a','h',',',' ','h','o','w',' ','a','r','e',' ','y','o','u','?'});
        MyString aaaaa=new MyString(new char[]{'a','a','a','a','a'});
        System.out.println(myString.indexOf(aaaaa));
        //MyString[] myStrings=myString.sentenceToWords(' ');
        MyString[] myStrings=myString.sentenceToWords(' ');
        for (int i = 0; i <myStrings.length ; i++) {
            myStrings[i].printMyString();
            System.out.println("");
        }
        aaaaa.toUpper();
        aaaaa.printMyString();

    }

}
