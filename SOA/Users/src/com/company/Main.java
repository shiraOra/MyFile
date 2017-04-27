package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    static List<User>users;
    static User loggedInUser;
    public static void main(String[] args) {
	// write your code here
        users=new LinkedList<>();
        loggedInUser=null;
        while (true){
            printMenu();
        }

    }
    public static void printMenu(){
        System.out.println();
        System.out.println("Please choose");
        System.out.println("1.sign up");
        System.out.println("2.log in");
        System.out.println("3.log out");
        System.out.println("4.reverse string");
        System.out.println("0.exit");
        System.out.println("your choise: ");
        try {
            int nextByte=System.in.read();
            if(nextByte==-1)
                throw new InvalidParameterException("input error");
            char c=(char)nextByte;
            switch (c){
                case '1':
                    signUp(0);
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '0':
                    System.out.println("bye bye");
                    return;
                default:
                    System.out.println("Invalid option. try again");

            }
            printMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void signUp(int counter){
        System.out.println("please enter a username");
        String userName=readInput();
        if (!User.isUserNameValid(userName)){
            System.out.println("username is invalid. try again");
            if (counter<3)
            signUp(counter+1);
            return;
        }
        User u=User.getUser(users,userName);
        if(u!=null){
            System.out.println("username is taken, Please choose another");
            if (counter<3)
                signUp(counter+1);
            return;
        }
        String password=null;
        String repeatPassword=null;
        do {
            if (password!= null)
                System.out.println("The password aren't equal");
            System.out.println("please enter a password");
            password = readInput();
            if (!User.isPasswordValid(password)) {
                System.out.println("password is invalid. try again");
                if (counter < 3)
                    signUp(counter + 1);
                return;
            }
            System.out.println();
            System.out.println("please enter password again");
            repeatPassword = readInput();
        }while (password.equals(repeatPassword));
    }
    public static void logIn(int counter) {
        System.out.println("please enter a username");
        String userName = readInput();
        if (!User.isUserNameValid(userName)) {
            System.out.println("username is invalid. try again");
            if (counter < 3)
                logIn(counter + 1);
            return;
        }
        User u = User.getUser(users, userName);
        System.out.println("please enter a password");
        String password = readInput();
        if (!User.isPasswordValid(password)) {
            System.out.println("password is invalid. try again");
            if (counter < 3)
                logIn(counter + 1);
            return;
        }
        if (u == null || !u.getPassword().equals(password)) {
            System.out.println("login failed. try again");
            if (counter < 3)
                logIn(counter + 1);
            return;
        }
        loggedInUser = u;
        System.out.println("welcome back" + userName);
    }
    static void logout(){
        if(loggedInUser==null) {
            System.out.println("no user is logged in");
            return;
        }
        loggedInUser=null;
        System.out.println("bye bye,see you later");
    }
    public static void reverseString(){
        if (loggedInUser==null){
            System.out.println("you must login first");
            return;
        }
        System.out.println("please enter a string: ");
        String s =readInput();
        char[]chars=s.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public static String readInput(){
        String input=null;
        BufferedReader bufferedReader=new BufferedReader(
                new InputStreamReader(System.in));
        try {
            input=bufferedReader.readLine();
            if (input.length()!=1){
                System.out.println("invalid input. try again");
                return readInput();
            }
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
