package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<String,Double> map = new TreeMap<>();

        fillMap(args[0],map);

        for (Map.Entry<String,Double> entry :
             map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    private static void fillMap(String fileName, TreeMap<String, Double> map) throws IOException
    {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            if (!map.containsKey(strings[0]))
            map.put(strings[0],Double.parseDouble(strings[1]));
            else  map.put(strings[0],map.get(strings[0]) + Double.parseDouble(strings[1]));
        }
        bufferedReader.close();
    }
}
