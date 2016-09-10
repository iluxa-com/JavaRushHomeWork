package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        while (bufferedReader.ready()){
            PEOPLE.add(getPersonFromString(bufferedReader.readLine()));
        }

        for (Person person :
                PEOPLE)
        {
            System.out.println(person.getName() +  " " + person.getBirthday());
        }
    }

    private static Person getPersonFromString(String s) throws ParseException
    {
        String[] personStrings = s.split(" ");
        String birthDayString = personStrings[personStrings.length-3] + "-" +
                                personStrings[personStrings.length-2] + "-" +
                                personStrings[personStrings.length-1];
        String name = "";

        for (int i = 0; i < personStrings.length - 3; i++)
        {
            name = name + " " + personStrings[i];
        }

        return new Person(name,(new SimpleDateFormat("dd-MM-yyyy")).parse(birthDayString));
    }

}
