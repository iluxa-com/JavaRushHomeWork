package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        String[] splitedURL = url.split("\\?");
        String[] params = splitedURL[1].split("&");

        KeyValue[] keyValues = new KeyValue[params.length];

        for (int i = 0; i < params.length; i++)
        {
            String[] kv = params[i].split("=");

            if (kv.length > 1) keyValues[i] = new KeyValue(kv[0], kv[1]);
            else keyValues[i] = new KeyValue(kv[0],null);
        }

        for (int i = 0; i < keyValues.length; i++)
        {
            System.out.print(keyValues[i].getKey());
            if (i != keyValues.length-1) System.out.print(" ");
        }
        System.out.println();

        for (KeyValue kv:
             keyValues)
        {
            if (kv.getKey().equals("obj")) {
                try
                {
                    alert(Double.parseDouble(kv.getValue()));
                }
                catch (NumberFormatException e)
                {
                    alert(kv.getValue());
                }
            }
        }



    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }

    public static class KeyValue{
        private String key,value;
        public KeyValue(String key, String value){
            if (key!=null) this.key=key;
            this.value = value;
        }

        public String getKey()
        {
            return key;
        }

        public String getValue()
        {
            return value;
        }
    }
}
