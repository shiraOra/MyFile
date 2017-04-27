package com.company;

import java.io.*;
import java.net.Socket;

/**
 * Created by hackeru on 3/29/2017.
 */
public class ClientThread extends Thread {
    private UploadedFile uploadedFile;
    private InputStream inputStream;
    private OutputStream outputStream;
    private Socket clientSocket;
    private OutputStream fileOutputStream;
    private InputStream fileInputStream;

    public static final int UPLOAD=100;
    public static final int DOWNLOAD=101;
    public static final int OK = 90;
    public static final int FAILURE = 80;

    public ClientThread(UploadedFile uploadedFile, Socket clientSocket) {

    }

    @Override
    public void run() {
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();
            switch (action) {
                case UPLOAD:
                    upload();
                    break;
                case DOWNLOAD:
                    download();
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }    finally{
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }if(inputStream!= null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }if (clientSocket!=null)
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }if(fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }if(fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

        private void download() throws IOException {
            if (uploadedFile.isLocked()){
                outputStream.write(FAILURE);
                return;
            }
            else
                outputStream.write((OK));
            fileInputStream=new FileInputStream(uploadedFile);
            int oneByte;
            while ((oneByte=fileInputStream.read())!=-1)
                outputStream.write(oneByte);
            fileInputStream.close();
            fileInputStream=null;
        }


        private void upload() throws IOException {

        boolean lock=false;
        synchronized (uploadedFile){
            if(!uploadedFile.isLocked()){
                uploadedFile.lock();
                lock=false;
            }
        }
        outputStream.write(lock?FAILURE:OK);
        if(lock)
            return;
        int fileNameLength = inputStream.read();
        if(fileNameLength == -1) {
            uploadedFile.unlock();
            return;

        }
        byte[] fileNameBytes = new byte[fileNameLength];
        int actuallyRead=inputStream.read(fileNameBytes);
        if(actuallyRead!=fileNameLength){
            uploadedFile.unlock();
            return;
        }
        OutputStream fileOutputStream=new FileOutputStream(uploadedFile);
        int oneByte;
        while ((oneByte=inputStream.read())!=-1)
            fileOutputStream.write(oneByte);
        fileOutputStream.close();
        fileOutputStream=null;
        uploadedFile.setFileNameBytes(fileNameBytes);
        uploadedFile.increaseVersion();
        }
    }

