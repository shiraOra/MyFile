package com.company;

/**
 * Created by hackeru on 2/22/2017.
 */
public class User {
    private String userName;
    private String password;

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

    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
         if (obj==this)
            return true;
        if (obj instanceof User) {
            User other =(User)obj;
            return (this.getPassword()==other.getPassword()&&this.getUserName()==other.getUserName());
        }
        else return false;
    }

    /**
     * UserName must contain lower case leeter....
     * @param userName
     * @return
     */
    static boolean isUserNameValid(String userName){
        if ((userName.length() < 3) ||(userName.length()>20))
            return false;
        byte[]userNameBytes=userName.getBytes();
       // int positionOffirstDigit=-1;
        boolean digitFound=false;
        for (int i = 0; i <userNameBytes.length ; i++) {
            int charCode =userNameBytes[i];
            boolean isDigit=charCode>=48&&charCode<=57;
            boolean isSmallLetter=charCode>=97&&charCode<=122;
            if(isDigit) {
                digitFound = true;
                if(i==0)
                    return false;
            }
            else if (digitFound)
                return false;
            if(!isDigit&&!isSmallLetter)
                return false;

        }
        return true;

    }
    static boolean isPasswordValid(String userPassword){
        if ((userPassword.length() < 3) ||(userPassword.length()>20))
            return false;
        byte[]userNameBytes=userPassword.getBytes();
        for (int i = 0; i <userNameBytes.length ; i++) {
            int charCode =userNameBytes[i];
            boolean isValidChar=charCode>=48&&charCode<=126;
            if (charCode<48||charCode>126)
                return false;
        }
        return true;

    }
    static User getUser(List<User> users,String userName) {
        for (User u : users) {
            if (u.getUserName().toUpperCase().equals(userName.toUpperCase()))
                return u;
        }
        return null;
    }
}
