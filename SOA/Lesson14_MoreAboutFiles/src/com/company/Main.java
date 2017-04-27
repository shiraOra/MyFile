package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // write your code here

        File file1 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\SOA\\");
        File file2 = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\SOA\\123.txt");
        System.out.println(getMaxFile(file1));
      /*  try {
            fileChoose();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
     /*   System.out.println(file.exists());
        System.out.println(file.isDirectory());*/
        /*File[] files=file.listFiles();
        for(File f: files){
            System.out.println( f.getAbsolutePath());
        }*/
//        System.out.println(fileInFolder(file1,file2));
//        System.out.println(file1);
    }

    /*public static boolean fileInFolder(File folder, String fileName) {
        if (!folder.exists())
            throw new InvalidParameterException("folder does not exist");
        if (!folder.isDirectory())
            throw new InvalidParameterException("this is not a folder");
        File[] files = folder.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().equals(fileName))
                return true;
        }
        for (File f: files){
            if(f.isDirectory()&&fileInFolder(f,fileName))
                return true;
        }
        r
    }*/


    public static void fileChoose() throws Exception {
        File file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\SOA");
        if (!file.exists())
            throw new Exception("does not exist");
        if (!file.isDirectory())
            throw new Exception("is not a directory");
        while (true) {
            System.out.println("please choose file");
            System.out.println("Enter 0 to go to parent directory");


            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println((i + 1) + " " + files[i].getName());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
            String line = bufferedReader.readLine();
            try {
                int option = Integer.valueOf(line);
                if (option < 0 || option > files.length)
                    throw new Exception("invalid option");
                if (option == 0) {
                    file = file.getParentFile();
                    continue;
                }
                File f = files[option - 1];
                if (f.isFile()) {
                    System.out.println("you have chosen the file");
                    System.out.println(f.getAbsolutePath());
                    break;
                } else
                    file = f;
            } catch (Exception ex) {
            }
        }
    }

    public static File getMaxFile(File file) {
        long maxSize = Integer.MIN_VALUE;
        File maxFile = null;
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.length()>maxSize){
                if(f.isFile()) {
                    maxSize = f.length();
                    maxFile = f;
                }
                else {
                    File maxFileInSubDirectory=getMaxFile(f);
                    if(maxFileInSubDirectory.length()>maxSize){
                        maxSize=maxFileInSubDirectory.length();
                        maxFile=maxFileInSubDirectory;
                    }
                }
            }
        }
        return maxFile;

    }
}

