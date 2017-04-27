package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by hackeru on 2/19/2017.
 */
public class User {

    public static final int ASCII_0 = 48;
    public static final int ASCII_9 = 57;
    public static final int ASCII_a = 97;
    public static final int ASCII_z = 122;
    public static final int ASCII_TILDA = 126;
    public static final String GEUST = "geust";
    private String userName;
    private String password;
    //private boolean isLogin;
    private static String loginUser=GEUST;
    public static ArrayList<User> userArrayList=new ArrayList<>();
    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static boolean isUserNameValid(String userName) {
        boolean isDigit = false;
        int i = 0;
        byte[] userNameBytes = userName.getBytes();
        int length = userNameBytes.length;
        if (!isLowerlCase(userNameBytes[i]))
            return false;
        i++;
        for (; i < length; i++) {
            if (isDigit) {
                if (!isDigit(userNameBytes[i]))
                    return false;
            } else {
                if (!(isLowerlCase(userNameBytes[i]) || isDigit(userNameBytes[i])))
                    return false;
                else if (isDigit(userNameBytes[i]))
                    isDigit = true;
            }
        }
        return true;
    }


    public static boolean isPasswordValid(String password) {
        byte[] passwordBytes = password.getBytes();
        int length = passwordBytes.length;
        if (length > 12 || length < 4)
            return false;
        for (int i = 0; i < length; i++) {
            if (passwordBytes[i] < ASCII_0 || passwordBytes[i] > ASCII_TILDA)
                return false;
        }
        return true;
    }

    public static boolean isDigit(byte b) {
        if (b >= ASCII_0 && b <= ASCII_9)
            return true;
        return false;
    }

    public static boolean isLowerlCase(byte b) {
        if (b >= ASCII_a && b <= ASCII_z)
            return true;
        return false;
    }

    public  static void reverseString(){
        String s=new String();
        System.out.println("Enter a string");
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newString= reverseString(s);
        System.out.println("The reverse string is ");

            System.out.println(newString);

        mainMenu();
    }

    public static String reverseString(String s) {
        byte[] sBytes = s.getBytes();
        int length = sBytes.length;
        byte[] newSBytes=new byte[length];
        for (int i = length-1,j=0; i >=0 ; i--,j++) {
            newSBytes[j]=sBytes[i];

        }

        String str = null;
        try {
            str = new String(newSBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;

    }

    public static void mainMenu() {
        String choise = new String();
        if (loginUser == GEUST) {

            System.out.println("Hello guest \n Did you register ever? press 1 to login \n Do you want to register? press 2 \n For exit press 3");
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                choise = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = new User();
            switch (toInt(choise)) {
                case 1:
                    user.logIn();
                    break;
                case 2:
                  signUp();
                    break;
                case 3:
                    break;
                default: {
                    System.out.println("i can't understand what do you want!\n Try again");
                    mainMenu();
                }
            }
        } else {
            System.out.println("Hello " + loginUser + ", What do you want to do?");
            System.out.println("press 1 for reverse a string  ,2 for logout and 3 for exit");
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                choise = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            User user = new User();
            switch (toInt(choise)) {
                case 1: {
                    reverseString();
                    break;
                }
                case 2:
                  logOut();
                    break;
                case 3:
                    break;
                default: {
                    System.out.println("i can't understand what do you want!\n Try again");
                    mainMenu();
                }

            }

        }
    }
    public static void signUp(){
        System.out.println("Enter a new user name or enter 0 for the main menu");
        String userName=new String();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            userName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(userName.equals("0"))
            mainMenu();
        if(!isUserNameValid(userName)){
            System.out.println("The user name is invalid");
            signUp();
        }
        if(findUser(userName)){
            System.out.println("This user name is exist ");
            signUp();
        }
        boolean arePasswordsEquals=false;
        String password1 = new String();
        String password2 = new String();
        while (!arePasswordsEquals) {
            System.out.println("Enter a password");

            bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                password1 = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!isPasswordValid(password1)) {
                System.out.println("The password is in valid");
                continue;
            }
            System.out.println("Enter the password again");

            bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            try {
                password2 = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (password1.equals(password2))
                arePasswordsEquals=true;
            else
                System.out.println("The 2 passwords aren't equal");
        }
        userArrayList.add(new User(userName,password1));
        loginUser=userName;
        mainMenu();
    }
    public static User findUser(boolean isfound,String userName) {
        if (isfound) {
            for (int i = 0; i < userArrayList.arr.length; i++) {
                if (userArrayList.arr[i].userName.equals(userName))
                    return userArrayList.arr[i];
            }
        }
        return null;
    }
    public static boolean findUser(String userName) {
        if (userArrayList.size==0)
            return false;
        else
            for (int i = 0; i < userArrayList.arr.length; i++) {
                if (userArrayList.arr[i].userName.equals(userName))
                    return true;
            }
        return false;
    }

    public void logIn(){
        System.out.println("Enter your user name");
        String name=new String();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            name = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user=findUser(findUser(name),name);
        if (user!=null)
        loginUser=this.getUserName();
        else
            System.out.println("The user name is incorrect");
        mainMenu();
    }
    public static void logOut(){
        loginUser= GEUST;
        mainMenu();
    }
    public static int toInt(String  s) {
        int num = 0, temp;
        if (!isInt(s))
            return -1;
        byte[] sBytes = s.getBytes();
        int sBytesLength = sBytes.length;
        for (int i = 0; i < sBytesLength; i++) {
            num = num * 10 + ((int) sBytes[i] - ASCII_0);
        }
        return num;
    }
    public static boolean isInt(String  num) {
        if (num == null || num.length() == 0)
            return false;
        byte[] numBytes = num.getBytes();
        int numBytesLength = numBytes.length;
        for (int i = 0; i < numBytesLength; i++) {
            if (numBytes[i] < ASCII_0 || numBytes[i] > ASCII_9)
                return false;
        }
        return true;
    }
}




