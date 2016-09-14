package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (bufferedReader1.ready()){
            String line = bufferedReader1.readLine();
            char[] array = line.toCharArray();

            for (int i = array.length-1; i >= 0; i--){
                System.out.print((char)array[i]);
            }
            System.out.println();
        }
        bufferedReader.close();
        bufferedReader1.close();
    }
}
