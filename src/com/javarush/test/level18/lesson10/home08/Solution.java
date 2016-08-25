package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(System.in));

        String fileName;

        while (!(fileName = bufferedReader.readLine()).equals("exit")){
            new  ReadThread(fileName);
        }


        for (Map.Entry<String,Integer> entry:resultMap.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        bufferedReader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName =fileName;
            this.start();
        }

        @Override
        public void run()
        {
            FileInputStream fileInputStream = null;
            int[] array = new int[256];

            try
            {
                fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0)
                    array[fileInputStream.read()]++;

            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            int max = 0;
            int maxByte = 0;

            for (int i = 0; i < array.length; i++)
            {
                if (array[i] > max) {
                    max = array[i];
                    maxByte = i;
                }
            }

            synchronized (resultMap)
            {
                resultMap.put(fileName, maxByte);
            }


        }

    }
}
