package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (bufferedReader.ready()){
            String[] words = bufferedReader.readLine().split(" ");
            for (int i = 0; i < words.length; i++)
            {
                if (words[i].length() > 6)
                {
                    fileWriter.write(words[i]);
                    if ( words.length-1 != i) fileWriter.write(",");
                }
            }
            if ( bufferedReader.ready()) fileWriter.write(",");
        }
        bufferedReader.close();
        fileWriter.close();

    }
}
