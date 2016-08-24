package com.javarush.test.level10.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел. Вывести 10-е и 11-е минимальные числа.
Пояснение:
Самое минимальное число – 1-е минимальное.
Следующее минимальное после него – 2-е минимальное
Пример:
1 6 5  7  1  15   63   88
Первое минимальное – 1
Второе минимальное – 1
Третье минимальное – 5
Четвертое минимальное – 6
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int[] array = { 1,-35, 21,  3,-78,  3,  0, 45, 10,-11,
//                        1, -1,101, 23,123,-32,178,-77,103,-43,
//                        4,-32,543,123,-12,532,-75, 33, -3,134};
        int[] array = new int[30];
        for (int i = 0; i < 30; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

//        for (int i = 0; i < 30; i++)
//        {
//            System.out.print(array[i]+", ");
//        }
//        System.out.println();
        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        for (int i = 0; i < 30; i++)
        {
            int min = array[i];
            for (int j = i+1; j < 30; j++)
            {
                if (array[j]<array[i]){
                    array[i] = array[j];
                    array[j] = min;
                    min= array[i];
                }
            }
        }
    }
}
