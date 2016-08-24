package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        int columnCount= 0;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available()>0){
            if (fileInputStream.read() == 44) columnCount++;
        }
        System.out.println(columnCount);
        bufferedReader.close();
        fileInputStream.close();
    }
}
