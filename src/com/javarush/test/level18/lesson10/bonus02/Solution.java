package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        int nextId = getNextId(fileName);
        String productName = "";
        for (int i = 1; i < args.length-2; i++)
            productName = productName + args[i] + " ";
        String price = args[args.length-2];
        String quantity = args[args.length-1];


        String result = "\n" + format(Integer.toString(nextId), 8) + format(productName, 30) + format(price, 8) + format(quantity, 4);

        try
        {
            Files.write(Paths.get(fileName), result.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            //exception handling left as an exercise for the reader
        }
    }

    private static int getNextId(String fileName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String str;
        String lastEntry = "";
        while ((str = bufferedReader.readLine()) != null) lastEntry = str;

        bufferedReader.close();

        return Integer.parseInt(lastEntry.substring(0, lastEntry.indexOf(" "))) + 1;
    }

    private static String format(String str, int length)
    {
        if (str.length() > length) return str.substring(0,length);
        else return String.format("%-" + length + "s", str);
    }
}
