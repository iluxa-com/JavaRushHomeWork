package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();


        HashMap<Integer,Integer> hashMap = new HashMap<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        while (fileInputStream.available() > 0){
            int byteFromFile = fileInputStream.read();
            int count = hashMap.containsKey(byteFromFile) ? hashMap.get(byteFromFile)+1 : 1;
            hashMap.put(byteFromFile,count);
        }

        int minCount = Byte.MAX_VALUE;

        for (Integer value :
                hashMap.values())
        {
            if (value < minCount) minCount = value;
        }

        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()
             )
        {
            if (entry.getValue() == minCount) System.out.print(entry.getKey() + " ");
        }

        bufferedReader.close();
        fileInputStream.close();
    }
}
