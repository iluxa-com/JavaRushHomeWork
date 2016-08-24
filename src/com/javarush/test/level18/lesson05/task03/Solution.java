package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());


        int firstHalf = 0;
        if (fileInputStream.available()%2 == 0) firstHalf = fileInputStream.available()/2;
        else firstHalf = fileInputStream.available()/2 + 1;

        for (int i = 0; i < firstHalf; i++)
            fileOutputStream1.write(fileInputStream.read());

        while (fileInputStream.available()>0)
            fileOutputStream2.write(fileInputStream.read());


        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
