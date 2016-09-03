package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static void main(String[] args) throws IOException, ParseException
    {
        Scanner scanner = new Scanner(new File("/home/user/19.3.4/test.txt"));
        PersonScannerAdapter adapter =  new PersonScannerAdapter(scanner);
        Person person = adapter.read();
        person = adapter.read();
        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String line;
            if (scanner.hasNextLine()) line = scanner.nextLine();
            else return null;
            String lastName = line.split(" ")[0];
            String firstName = line.split(" ")[1];
            String middleName = line.split(" ")[2];
            Date birthDay = (new SimpleDateFormat("dd MM yyyyy").parse(line.split(" ")[3]
                                                                                + " " + line.split(" ")[4]
                                                                                + " " + line.split(" ")[5]));

            return new Person(firstName, middleName ,lastName, birthDay);
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
