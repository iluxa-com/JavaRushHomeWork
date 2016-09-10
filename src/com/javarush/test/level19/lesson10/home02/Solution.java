package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<String,Double> map = new TreeMap<>();

        fillMap(args[0],map);

        double max = 0;

        for (Map.Entry<String,Double> entry :
                map.entrySet())
        {
            if (max< entry.getValue()) max = entry.getValue();
        }

        for (Map.Entry<String, Double> entry :
                 map.entrySet() )
        {
            if (entry.getValue() == max ) System.out.println(entry.getKey());
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
