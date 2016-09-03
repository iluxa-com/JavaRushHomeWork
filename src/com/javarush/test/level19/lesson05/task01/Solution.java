package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fos = new FileOutputStream(bufferedReader.readLine());

        bufferedReader.close();

        int count =1;
        while (fis.available() > 0 )
        {
            int b = fis.read();
            if (count%2 == 0) fos.write(b);
            count++;
        }

        fis.close();
        fos.close();
    }
}
