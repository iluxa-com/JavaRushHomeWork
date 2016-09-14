package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.*;

public class Solution {
    private static boolean showAd = false;
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {
        PrintStream systemOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(myPrintStream);

        testString.printSomething();

        System.setOut(systemOut);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                                        (new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));

        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
            if (showAd) System.out.println("JavaRush - курсы Java онлайн");
            showAd = !showAd;
        }

        byteArrayOutputStream.close();
        myPrintStream.close();
        bufferedReader.close();

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
