package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = bufferedReader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(firstFileName);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());

        byte[] array = new byte[fileInputStream1.available()];

        fileInputStream1.read(array);

        FileOutputStream fileOutputStream1 = new FileOutputStream(firstFileName);

        while (fileInputStream2.available() > 0 ) fileOutputStream1.write(fileInputStream2.read());


        fileOutputStream1.write(array);


        bufferedReader.close();
        fileInputStream2.close();
        fileInputStream1.close();
        fileOutputStream1.close();

    }
}
