package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();

        int byteArray[]  = new int[255];

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            byteArray[fileInputStream.read()]++;
        }

        int maxCount=0;
        for (int i :
                byteArray)
        {
            if (i > maxCount) maxCount = i;
        }


        for (int i = 0; i < byteArray.length; i++)
        {
            if (byteArray[i] == maxCount) System.out.print(i + " ");
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
