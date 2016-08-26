package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeSet<String> set = new TreeSet<>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                int k = Integer.parseInt(o1.substring(o1.indexOf(".part") + 5));
                int m = Integer.parseInt(o2.substring(o2.indexOf(".part") + 5));
                if (k > m)return 1;
                else if (k < m) return -1;
                else return 0;
            }
        });
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = bufferedReader.readLine()).equals("end")){
            set.add(input);
        }

        int resFileNameLength = set.first().lastIndexOf(".part");
        String resFileName = set.first().substring(0,resFileNameLength);


        FileOutputStream fileOutputStream = new FileOutputStream(resFileName);

        for (String fileName :
                set)
        {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            byte[] bytes = new byte[100];
            while (fileInputStream.available() > 0)
            {
                int count = fileInputStream.read(bytes);
                fileOutputStream.write(bytes,0,count);
            }
            fileInputStream.close();
        }

        bufferedReader.close();
        fileOutputStream.close();

    }
}
