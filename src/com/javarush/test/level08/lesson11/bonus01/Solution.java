package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //напишите тут ваш код
        ArrayList<String> months = new ArrayList<>(Arrays.asList("January","February","March","April","May"
                                                                ,"June","July","August","September"
                                                                ,"October","November","December"));
//        HashSet<String> months = new HashSet<>(Arrays.asList("January","February","March","April","May"
//                                                                        ,"June","July","August","September"
//                                                                        ,"October","November","December"));
        String month;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        month = reader.readLine();

        System.out.println(month+" is "+ (months.indexOf(month)+1) + " month");

    }

}
