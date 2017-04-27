package com.company;

import com.sun.deploy.util.SessionState;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {
    public static final int PORT = 3000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                System.out.println("waiting");
                Socket socket=serverSocket.accept();
                System.out.println("Client conenected");
                ClientThread clientThread=new ClientThread(socket);
                clientThread.start();
            }
                }
         catch (IOException e) {
            e.printStackTrace();
        }
    }
}
