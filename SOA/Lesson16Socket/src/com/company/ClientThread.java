package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created by hackeru on 3/9/2017.
 */
public class ClientThread extends Thread{
    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

            try
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
            byte[] buffer = new byte[10];
            int actuallyRead = inputStream.read(buffer);
            int firstNum = ByteBuffer.wrap(buffer).getInt(0);
            int secondNum = ByteBuffer.wrap(buffer).getInt(4);
            char action=ByteBuffer.wrap(buffer).getChar(8);
            switch (action) {
                case '+': {
                    System.out.println("The sum of the numbers is " + (firstNum + secondNum));
                    break;
                }
                case '-':{
                    System.out.println("The subtract of the numbers is " + (firstNum - secondNum));
                    break;
                }
                case '/':{
                    System.out.println("The division of the numbers is " + (firstNum / secondNum));
                    break;
                }
                case '*':{
                    System.out.println("The product of the numbers is " + (firstNum * secondNum));

                    break;
                }
                default:
                    System.out.println("The input isn't correct");
            }
    }
}
