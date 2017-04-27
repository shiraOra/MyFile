package com.company;
import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {

    public static final int PORT = 3000;


    //SOCKET CLIENT
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;
        try {
            Socket socket = new Socket("127.0.0.1", PORT); //loopback
            inputStream=socket.getInputStream();
            outputStream=socket.getOutputStream();
            byte[] buffer=new byte[10];
            System.out.println("Type the first number");
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            int firstNum= Integer.parseInt(bufferedReader.readLine());
            ByteBuffer.wrap(buffer).putInt(firstNum);
            System.out.println("Type the second number");
            int secondNum= Integer.parseInt(bufferedReader.readLine());
            ByteBuffer.wrap(buffer).putInt(4,secondNum);
            System.out.println("Type the action you want to do");
            char c=bufferedReader.readLine().charAt(0);
            ByteBuffer.wrap(buffer).putChar(8,c);
            outputStream.write(buffer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}