package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader = new BufferedReader(new FileReader(fileName));

        Pattern pattern = Pattern.compile("\\bworld\\b");
        int count = 0;

        while (reader.ready())
        {
            Matcher matcher = pattern.matcher(reader.readLine());
            while (matcher.find())
            {
                count++;
            }
        }

        System.out.println(count);

        reader.close();
    }}
