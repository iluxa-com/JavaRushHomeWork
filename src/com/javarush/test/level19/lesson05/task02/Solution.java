package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName =bufferedReader.readLine();

        bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        int wordCount = 0;
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split(" ");
            for (String str:
                 strings)
            {
                if (str.contains("word")) wordCount++;
            }
        }

        bufferedReader.close();

        System.out.println(wordCount);

    }
}
