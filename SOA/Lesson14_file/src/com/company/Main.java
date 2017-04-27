package com.company;
import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here

        writeIntsToFile(new File("C:\\Users\\hackeru.HACKERU3\\Documents\\MyFile.dat"));
        System.out.println( max(new File("C:\\Users\\hackeru.HACKERU3\\Documents\\MyFile.dat")));
        File file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\MyFile.txt");
        //עצם קיומו של משתנה מסוג File לא מבטיח שיש קובץ בנתיב הזה במחשב
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write("Shira".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[64];
            int actuallyRead=inputStream.read(buffer);
            if (actuallyRead!=-1){
                String  s =new String(buffer,0,actuallyRead);
                System.out.println(s);
            }

            //int actuallyRead;
            StringBuilder stringBuilder = new StringBuilder();
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, actuallyRead));
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void writeIntsToFile(File file) {
        Random random = new Random(System.currentTimeMillis());
        int numbers = random.nextInt(100000) + 100000;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[]bytes=new byte[4];
            for (int i = 0; i < numbers; i++) {
                int num = random.nextInt();
                ByteBuffer.wrap(bytes).putInt(num);
                outputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int max(File file) {
        int max = Integer.MIN_VALUE;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buffer = new byte[4];
            int actuallyRead;
            StringBuilder stringBuilder = new StringBuilder();
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
               if(actuallyRead!=4)
                   throw new InvalidParameterException();
                int num=ByteBuffer.wrap(buffer).getInt();
                if (num>max)
                    max=num;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }
        return max;
    }

    public static void reverseFile(){

    }
}
