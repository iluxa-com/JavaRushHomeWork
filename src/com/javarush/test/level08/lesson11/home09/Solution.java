package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{

    public static void main(String[] args) throws ParseException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputDate = reader.readLine();
        System.out.println(inputDate+" = "+(isDateOdd(inputDate)));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        int daysCount;
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date convertedDate = format.parse(date);

        DateFormat days = new SimpleDateFormat("D");

        daysCount = Integer.parseInt(days.format(convertedDate));

        return daysCount%2 == 0 ? false : true;
    }
}
