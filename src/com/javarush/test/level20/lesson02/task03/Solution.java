package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.lang.System.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {

    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();

        for (Map.Entry entry :
                properties.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        FileOutputStream fileOutputStream = new FileOutputStream("/home/user/20.2.3/test-out.properties");
        sol.save(fileOutputStream);


    }

    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
        load(new FileInputStream(fileName));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        for (Map.Entry entry:
        properties.entrySet())
        {
            outputStream.write((entry.getKey() + ":" + entry.getValue() + "\r").getBytes());
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);

        for (String key : props.stringPropertyNames())
        {
            properties.put(key,props.getProperty(key));

        }

        inputStream.close();

    }

}

