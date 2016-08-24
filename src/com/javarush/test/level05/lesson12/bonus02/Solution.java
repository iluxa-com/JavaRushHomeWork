package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++)
        {
            nums[i]= Integer.parseInt(reader.readLine());
            if (nums[i]<minimum) minimum = nums[i];
        }




        System.out.println("Minimum = " + minimum);
    }



}
