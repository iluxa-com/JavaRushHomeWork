package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(new File(bufferedReader.readLine()));
        sc.useLocale(Locale.US);
        FileOutputStream file2 = new FileOutputStream(bufferedReader.readLine());

        Double number;

        while (sc.hasNextDouble()) {
            number = sc.nextDouble();
            int rounded = round(number);
            file2.write(Integer.toString(rounded).getBytes());
            file2.write(32);
        }

        bufferedReader.close();
        sc.close();
        file2.close();

    }

    private static int round(double number)
    {
        int  iPart = (int)number;
        double fPart = number - iPart;

        if (number > 0 ){
            if (fPart >= 0.50) return iPart+1;
            else return iPart;
        }
        else {
            if (fPart < -0.5) return iPart-1;
            else return iPart;
        }


    }
}
