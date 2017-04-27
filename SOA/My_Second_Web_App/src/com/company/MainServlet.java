package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hackeru on 4/20/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {

    int counter=0;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("in doPost");
        InputStream inputStream=request.getInputStream();
        byte[] buffer=new byte[1024];
        int actuallyRead=inputStream.read(buffer);
        String body=new String(buffer,0,actuallyRead);
        System.out.println(body);

        String result="response"+counter;
        counter++;
        byte[] resultByte=result.getBytes();
        OutputStream outputStream=response.getOutputStream();
        outputStream.write(resultByte);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("hello!");
        String queryString=request.getQueryString();
        System.out.println(queryString);
        Map<String,String> qs=new HashMap<>();
        if(qs!=null)
        {
            String[]keyValues=queryString.split("&");
            for (String keyValue:keyValues) {
                String[] keyValuePair=keyValue.split("=");
                if(keyValuePair.length!=2)
                    continue;
                qs.put(keyValuePair[0],keyValuePair[1]);
            }
        }
        System.out.println(qs.get("username"));
        System.out.println(qs.get("password"));

    }
}
