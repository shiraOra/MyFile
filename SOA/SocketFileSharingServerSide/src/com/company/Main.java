package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static final int PORT=3000;
    public static final String PATH_TO_UPLOAD_FILE="C:\\Users\\hackeru.HACKERU3\\Documents\\SOA\\Files";
    public static void main(String[] args) {

        UploadedFile uploadedFile=new UploadedFile(PATH_TO_UPLOAD_FILE);
        ServerSocket serverSocket=null;
        try {
            serverSocket= new ServerSocket(PORT);
            Socket clientSocket=serverSocket.accept();
            ClientThread clientThread=new ClientThread(uploadedFile,clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
