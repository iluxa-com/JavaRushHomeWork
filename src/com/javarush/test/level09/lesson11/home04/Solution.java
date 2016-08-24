package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        input= reader.readLine();
//        input = "12/05/2015";
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);

        Date date = format.parse(input);
        format.applyPattern(" dd, yyyy");

        String dayAndYear= format.format(date);
        format.applyPattern("MMM");
        String month = format.format(date).toUpperCase();

        System.out.println(month+dayAndYear);

    }
}
