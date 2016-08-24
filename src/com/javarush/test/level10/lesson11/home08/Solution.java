package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Arrays;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] array;
        array = new ArrayList[5];
        array[0] = new ArrayList<>(Arrays.asList("111","wer","test"));
        array[1] = new ArrayList<>(Arrays.asList("222","wer","test"));
        array[2] = new ArrayList<>(Arrays.asList("333","wer","test"));
        array[3] = new ArrayList<>(Arrays.asList("444","wer","test"));
        array[4] = new ArrayList<>(Arrays.asList("555","wer","test"));


        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}