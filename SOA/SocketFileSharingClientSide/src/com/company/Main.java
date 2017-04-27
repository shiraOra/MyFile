/*
package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static final int UPLOAD=100;
    public static final int DOWNLOAD=101;
    public static final int OK = 90;
    public static final int FAILURE = 80;
    public static final int PORT=3000;
    public static final String SERVER_IP="127.0.0.1";
    static int existingVersion=0;
    public static void main(String[] args) {
	    File downloadPath=getDownloadPath();
	    if(downloadPath==null)
            exit();
	    while(true) {
            MenuChoice choice = menu();
            switch (choice) {
                case UPLOAD:
                    uploadChoice();
                    break;
                case DOWNLOAD:
                    downloadChoice(downloadPath);
                    break;
            }

        }


    }
    static MenuChoice menu(){
        System.out.println("please choose");
        System.out.println("1. upload file");
        System.out.println("2. download file");
        System.out.println("type exit in any time to close the program");
        String choice=getUserInput();
        switch (choice)
        {
            case "1":
                return MenuChoice.UPLOAD;
                //break;
            case "2":
                return MenuChoice.DOWNLOAD;
                //break;
            case "exit":
                exit();
                break;
        }
        return null;
    }
    static void uploadChoice(){
        while (true) {
            System.out.println("please enter path");
            String input = getUserInput();
            File  fileToUpload=new File(input);
            if(fileToUpload.exists()&&fileToUpload.isFile()){
               if( uploadToServer(fileToUpload)){
                   System.out.println("uploaded successfully");
                    break;
               }
               else
                   System.out.println("error");
            }else
                System.out.println("file doesn't exist or not file");
        }
    }
    static boolean uploadToServer(File fileToUpload){
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(SERVER_IP, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(UPLOAD);
            int response = inputStream.read();
            if(response != OK)
                return false;
            byte[] fileNameBytes = fileToUpload.getName().getBytes();
            outputStream.write(fileNameBytes.length);
            InputStream fileInputStream = new FileInputStream(fileToUpload);
            int oneByte;
            while((oneByte = fileInputStream.read()) != -1){
                outputStream.write(oneByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(inputStream, outputStream, socket);
        }
        return true;
    }
    static void downloadChoice(File downloadPath){
        System.out.println("downloading...");
        String downloadedFileName;
        if((downloadedFileName=downloadFromServer(downloadPath))!=null)
            System.out.println("downloaded successfully to"+downloadedFileName);
        else {
            System.out.println("error");
        }

    }
    static String downloadFromServer (File downloadPath, int version) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(SERVER_IP, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(DOWNLOAD);
            int response = inputStream.read();
            if (response != OK)
                return null;
            int fileNameLength = inputStream.read();
            if (fileNameLength == -1)
                return null;
            byte[] fileNameBytes = new byte[fileNameLength];
            int actuallyRead = inputStream.read(fileNameBytes);
            if (actuallyRead != fileNameLength)
                return null;
            File downloadedFile=new File(downloadPath,new String(fileNameBytes));
            OutputStream fileOutputStream=new FileOutputStream(downloadedFile);
            InputStream inputStream=new FileInputStream()
            int oneByte;
            while (oneByte=fileInputStream.read()!=-1){

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void close(Closeable... closeables){
        for (Closeable closeable:closeables)
            if(closeable!=null)
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

     static File getDownloadPath(){
        while (true) {
            System.out.println("please enter a download directory");
            String pathString = getUserInput();
            if (pathString.equals("exit"))
                return null;
            File file = new File(pathString);
            if (file.exists() && file.isDirectory())
                return file;
            System.out.println("invalid Path");
        }
    }
    static String getUserInput(){
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static void exit(){
        System.out.println("bye");
        System.exit(0);

    }
    enum MenuChoice{
        UPLOAD,DOWNLOAD
    }
}
*/


package com.company;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Main {

    public static final String SERVER_IP = "10.0.11.49";
    public static final int PORT = 3000;

    public static final int UPLOAD = 100;
    public static final int DOWNLOAD = 101;
    public static final int OKAY = 90;
    public static final int FAILURE = 91;


    static int existingVersion = 0;

    public static void main(String[] args) {
        File downloadPath = getDownloadPath();

        if(downloadPath == null){//user typed "exit" so we break out of the program
            exit();
        }
        while (true) {
            MenuChoice choice = menu();
            switch (choice) {
                case UPLOAD:
                    uploadChoice();
                    break;
                case DOWNLOAD:
                    downloadChoice(downloadPath);
                    break;
            }
        }

	    /*InputStream inputStream1 = null;
	    OutputStream outputStream1 = null;
	    InputStream inputStream2 = null;
	    Closeable[] closeables = new Closeable[3];
	    closeables[0] = inputStream1;
	    closeables[1] = inputStream2;
	    closeables[2] = outputStream1;
	    close(inputStream1, inputStream2, outputStream1);*/
    }

    static void uploadChoice(){
        while(true) {
            System.out.println("please enter path to file to upload:");
            String input = getUserInput();
            File fileToUpload = new File(input);
            if(fileToUpload.exists() && fileToUpload.isFile()){
                if(uploadToServer(fileToUpload)) {
                    System.out.println("uploaded successfully");
                    break;
                }
                else
                    System.out.println("error uploading file");
            }else{
                System.out.println("file doesn't exist or is a directory");
            }
        }
    }

    static void downloadChoice(File downloadPath){
        System.out.println("downloading...");
        DownloadResult downloadResult = downloadFromServer(downloadPath);
        if(downloadResult.getErrorCode() == DownloadResult.SUCCESS){
            System.out.println("downloaded successfully to " +
                    downloadResult.getFileName());
        }else if(downloadResult.getErrorCode() == DownloadResult.NETWORK_ERROR){
            System.out.println("error downloading");
        }else if(downloadResult.getErrorCode() == DownloadResult.ALREADY_HAVE_LATEST_VERSION){
            System.out.println("you already have the latest version");
        }else{
            System.out.println("unknown error");
        }
    }

    static MenuChoice menu(){
        while(true) {
            System.out.println("please choose:");
            System.out.println("1. upload file");
            System.out.println("2. download file");
            System.out.println("type 'exit' at any time to exit this program.");
            String choiceString = getUserInput();
            switch (choiceString){
                case "1":
                    return MenuChoice.UPLOAD;
                case "2":
                    return MenuChoice.DOWNLOAD;
                case "exit":
                    exit();
                    break;

            }
        }
    }

    static File getDownloadPath(){
        while(true) {
            System.out.println("please enter a download directory:");
            String pathString = getUserInput();
            if(pathString.equals("exit"))
                return null;
            File file = new File(pathString);
            if (file.exists() && file.isDirectory())
                return file;
            System.out.println("invalid path");
        }
    }

    static String getUserInput(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    static void exit(){
        System.out.println("bye bye");
        System.exit(0);
    }


    static boolean uploadToServer(File fileToUpload){
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        InputStream fileInputStream = null;
        try {
            socket = new Socket(SERVER_IP, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(UPLOAD);
            int response = inputStream.read();
            if(response != OKAY)
                return false;
            byte[] fileNameBytes = fileToUpload.getName().getBytes();
            outputStream.write(fileNameBytes.length);
            outputStream.write(fileNameBytes);
            fileInputStream = new FileInputStream(fileToUpload);
            int oneByte;
            while((oneByte = fileInputStream.read()) != -1){
                outputStream.write(oneByte);
            }
            fileInputStream.close();
            fileInputStream = null;

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(inputStream, outputStream, socket, fileInputStream);
        }
        return true;
    }

    static DownloadResult downloadFromServer(File downloadPath){
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        OutputStream fileOutputStream = null;
        DownloadResult downloadResult = new DownloadResult();
        try {
            socket = new Socket(SERVER_IP, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(DOWNLOAD);
            int response = inputStream.read();
            if(response != OKAY) {
                downloadResult.setErrorCode(DownloadResult.NETWORK_ERROR);
                return downloadResult;
            }
            byte[] versionBytes = new byte[4];
            int actuallyRead;
            actuallyRead = inputStream.read(versionBytes);
            if(actuallyRead != 4){
                downloadResult.setErrorCode(DownloadResult.NETWORK_ERROR);
                return downloadResult;
            }
            int version = ByteBuffer.wrap(versionBytes).getInt();
            if(version == existingVersion){
                outputStream.write(FAILURE);
                outputStream.close();
                outputStream = null;
                downloadResult.setErrorCode(DownloadResult.ALREADY_HAVE_LATEST_VERSION);
                return downloadResult;
            }else{
                outputStream.write(OKAY);
            }

            int fileNameLength = inputStream.read();
            if(fileNameLength == -1){
                downloadResult.setErrorCode(DownloadResult.NETWORK_ERROR);
                return downloadResult;
            }
            byte[] fileNameBytes = new byte[fileNameLength];
            actuallyRead = inputStream.read(fileNameBytes);
            if(actuallyRead != fileNameLength){
                downloadResult.setErrorCode(DownloadResult.NETWORK_ERROR);
                return downloadResult;
            }
            String fileName = new String(fileNameBytes);
            File downloadedFile = new File(downloadPath, fileName);
            downloadResult.setFileName(fileName);
            fileOutputStream = new FileOutputStream(downloadedFile);
            int oneByte;
            while((oneByte = inputStream.read()) != -1){
                fileOutputStream.write(oneByte);
            }
            fileOutputStream.close();
            fileOutputStream = null;
            downloadResult.setErrorCode(DownloadResult.SUCCESS);
            existingVersion = version;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(inputStream, outputStream, socket, fileOutputStream);
        }

        return downloadResult;
    }


    static void close(Closeable... closeables){
        for(Closeable closeable : closeables){
            if(closeable != null)
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


}
enum MenuChoice{
    UPLOAD, DOWNLOAD
}

class DownloadResult {

    public static final int SUCCESS = 0;
    public static final int ALREADY_HAVE_LATEST_VERSION = 1;
    public static final int NETWORK_ERROR = 2;

    private int errorCode;
    private String fileName;

    public DownloadResult(String fileName) {
        this.fileName = fileName;
    }

    public DownloadResult() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}