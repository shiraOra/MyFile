package com.company;

import java.util.Map;

/**
 * Created by hackeru on 3/8/2017.
 */
public class MyThread extends Thread {

    Map<String,String> users;
    String userName,password;
    MyInteger myInteger;

    public MyThread(Map<String, String> users, String userName, String password, MyInteger myInteger) {
        this.users = users;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void run() {
        boolean success=false;
        synchronized (users) {
            if (!users.containsKey(userName)) {
                users.put(userName, password);
                success=true;
            }
        }
        if(success) {
            // update the user for success
        }
        else{
            // update the user that this user name is exist.
        }
        myInteger.x++;
    }
}
