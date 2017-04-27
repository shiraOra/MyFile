package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
       /* File testFile=new File("\\Users\\hackeru.HACKERU3\\Documents\\testFile.txt");
        writeIntegersFile(testFile);
        int arr[]= ex2(testFile,3);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }*/
        File testFile1 = new File("\\Users\\hackeru.HACKERU3\\Documents\\testFile1.txt");
        File testFile2 = new File("\\Users\\hackeru.HACKERU3\\Documents\\testFile2.txt");
        File mergeTestFile = new File("\\Users\\hackeru.HACKERU3\\Documents\\mergeTestFile.txt");
        writeIntegersFile1(testFile1);
        writeIntegersFile2(testFile2);
        ex1(testFile1, testFile2, mergeTestFile);
        int[] arr = getIntegers(mergeTestFile);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


    public static void ex1(File file1, File file2, File mergeFile) {
        InputStream inputStream1;
        InputStream inputStream2;
        OutputStream outputStream;

        try {
            inputStream1 = new FileInputStream(file1);
            inputStream2 = new FileInputStream(file2);
            outputStream = new FileOutputStream(mergeFile);
            byte[] bytes1 = new byte[4];
            byte[] bytes2 = new byte[4];
            byte[] bytes = new byte[4];
            int num1, num2;
            int actuallyRead1;
            int actuallyRead2;
            while (true) {
                if (ByteBuffer.wrap(bytes1).getInt() > ByteBuffer.wrap(bytes2).getInt()) {
                    outputStream.write(bytes1);
                    if ((actuallyRead1 = inputStream1.read(bytes1)) == -1)
                        break;
                }
                else {
                    outputStream.write(bytes2);
                    if ((actuallyRead2 = inputStream2.read(bytes2)) == -1)
                        break;
                }


            }
          /*  while (true) {
                if ((actuallyRead1 = inputStream1.read(bytes1)) != -1)
                     num1 = ByteBuffer.wrap(bytes1).getInt();
                else
                    break;
                if ((actuallyRead2 = inputStream2.read(bytes2)) != -1)
                    num2 = ByteBuffer.wrap(bytes2).getInt();
                else
                    break;
                if (num1 < num2) {
                    ByteBuffer.wrap(bytes).putInt(num1);
                    //num1 = ByteBuffer.wrap(bytes1).getInt();
                } else {
                    ByteBuffer.wrap(bytes).putInt(num2);
                    //num2 = ByteBuffer.wrap(bytes2).getInt();
                }
                outputStream.write(bytes);
            }*/
            /*while ((actuallyRead1 = inputStream1.read(bytes1)) != -1) {
                ByteBuffer.wrap(bytes).putInt(num1);
                outputStream.write(bytes);
                num1 = ByteBuffer.wrap(bytes1).getInt();
            }
            while ((actuallyRead2 = inputStream2.read(bytes2)) != -1) {
                ByteBuffer.wrap(bytes).putInt(num2);
                outputStream.write(bytes);
                num2 = ByteBuffer.wrap(bytes2).getInt();
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] ex2(File file, int k) {
        //int arr[]=new int [k];
        ArrayList arrayList = new ArrayList();
        int j = 0;
        int index;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[4];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(bytes)) != -1) {
                int num = ByteBuffer.wrap(bytes).getInt();
                if (j < k) {
                    index = j;
                    for (int i = 0; i < j; i++) {
                        if (arrayList.get(i) > num) {
                            index = i;
                            break;
                        }
                    }
                    if (j == 0)
                        arrayList.add(num);
                    else
                        arrayList.add(num, index);
                    j++;
                } else {
                    for (int i = 0; i < k; i++) {
                        if (arrayList.get(i) > num) {
                            arrayList.addWithoutChangeSize(num, i);
                            break;
                        }

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList.toArray();
    }
   /* public static int Ex4(File file){
        long x=file.length();
        Random random = new Random(System.currentTimeMillis());
        int numberOfIntegers = random.nextInt();
    }*/

    //הפונקציה משמשת כלי לבדיקת תרגיל 2

    static void writeIntegersFile(File file) {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[4];
            for (int i = 5; i > 0; i--) {
                ByteBuffer.wrap(bytes).putInt(i);
                outputStream.write(bytes);
            }
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

    }

    static void writeIntegersFile1(File file) {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[4];
            for (int i = 2; i < 7; i += 2) {
                ByteBuffer.wrap(bytes).putInt(i);
                outputStream.write(bytes);
            }
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

    }

    static void writeIntegersFile2(File file) {
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[4];
            for (int i = 1; i < 5; i += 2) {
                ByteBuffer.wrap(bytes).putInt(i);
                outputStream.write(bytes);
            }
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

    }

    static int[] getIntegers(File file) {
        InputStream inputStream = null;
        int[] arr = new int[10];
        int i = 0;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[4];
            int actuallyRead;
            while ((actuallyRead = inputStream.read(bytes)) != -1) {
                if (actuallyRead != 4)
                    throw new InvalidParameterException("עבדת עלי זה בכלל לא מספרים");
                int num = ByteBuffer.wrap(bytes).getInt();
                arr[i] = num;
                i++;
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
        return arr;
    }


}
