package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.awt.Color.white;
import static java.awt.SystemColor.text;
import static java.util.Collections.sort;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        reader = new BufferedReader(new InputStreamReader(fileInputStream));


        ArrayList<Integer> arrayList = new ArrayList<>();
        String text;
        //            System.out.println(fileInputStream.read());

        while(true){
            text = reader.readLine();
            if (text!=null)
            arrayList.add(Integer.parseInt(text));
            else break;
        }

        sort(arrayList);
        for (int num :
                arrayList)
        {
            if (num % 2 == 0) System.out.println(num);
        }
    }
}
