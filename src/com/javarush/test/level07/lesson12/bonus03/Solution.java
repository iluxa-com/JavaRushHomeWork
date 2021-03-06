package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        int max;
        int maxIndex = 0;
        int sortedBound = 0;

        do
        {
            max = Integer.MIN_VALUE;

            for (int i = sortedBound; i < array.length; i++)
            {
                if (array[i] > max)
                {
                    maxIndex = i;
                    max=array[i];
                }
            }

            int swap = array[maxIndex];
            array[maxIndex] = array[sortedBound];
            array[sortedBound] = swap;
            sortedBound++;
        }
        while (sortedBound < array.length);


    }
}
