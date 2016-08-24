package com.javarush.test.level08.lesson08.task02;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> set= createSet();
        System.out.println(set);
        System.out.println(removeAllNumbersMoreThan10(set));
    }
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++)
        {
            set.add(i);
        }

        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        HashSet<Integer> newSet = new HashSet<>();

        for (int num :
                set)
        {
            if (num <= 10) newSet.add(num);
        }

        set=newSet;

        return set;

    }
}
