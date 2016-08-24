package com.javarush.test.level07.lesson12.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Вводить с клавиатуры строки, пока пользователь не введёт строку 'end'
Создать список строк.
Ввести строки с клавиатуры и добавить их в список.
Вводить с клавиатуры строки, пока пользователь не введёт строку "end".  "end" не учитывать.
Вывести строки на экран, каждую с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        String text;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            text = reader.readLine();
            if (text.equals("end")) break;
            list.add(text);
        }

        for (String string:
             list)
            System.out.println(string);

        //напишите тут ваш код
    }
}
