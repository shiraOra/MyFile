package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;


public class Main {

    public static final String HOST = "10.0.11.49";

    public static void main(String[] args) {
     /*   System.out.println("please enter company name");
        String companyName=getInputFromUser();*/

     /*   try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT CUSTOMER_ID,COMPANY_NAME,CONTACT_NAME FROM CUSTOMERS WHERE COMPANY_NAME= ? ");//
            statement.setString(1, companyName);
            try(ResultSet resultSet=statement.executeQuery()){
                while (resultSet.next()){
                    String customerId=resultSet.getString(1);
                    //String companyName=resultSet.getString(2);
                    String contactName=resultSet.getString(3);
                    System.out.println(customerId+" "+companyName+ " " +contactName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("SELECT SUM(UNIT_PRICE*QUANTITY*(1-DISCOUNT)) AS TotalPrice\n" +
                    "FROM ORDER_DETAILS ");//
            try(ResultSet resultSet=statement.executeQuery()){
                while (resultSet.next()){
                    String sum=resultSet.getString(1);
                    System.out.println(sum);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static String getInputFromUser() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}



//הלקוח שעשה את המכירה הכי גדולה מותר להשתמש בORDER BY זיכרון O1 לא בWHERE INNER GOIN