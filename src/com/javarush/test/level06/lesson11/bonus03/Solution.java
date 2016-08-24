package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++)
        {
            int num =Integer.parseInt(reader.readLine());

            for (int j = 0; j <= i; j++)
            {
                if (num<nums[j]) {
                    putNumberOnPosition(num,j,nums);
                    break;
                }
                if (i==j) nums[i]=num;

            }

        }

        for (int i = 0; i < 5; i++)
        {
            System.out.println(nums[i]);
        }

        //напишите тут ваш код
    }

    private static void putNumberOnPosition(int num,int position,int[] nums)
    {
        for (int i = nums.length-1; i > position; i--)
        {
            nums[i]=nums[i-1];
        }
        nums[position]=num;
    }
}
