package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());

        byte array[] = new byte[fileInputStream.available()];

        fileInputStream.read(array);

        for (int i = array.length; i > 0 ; i--)
        {
            fileOutputStream.write(array[i-1]);
        }

        fileInputStream.close();
        fileOutputStream.close();
        bufferedReader.close();

    }
}
