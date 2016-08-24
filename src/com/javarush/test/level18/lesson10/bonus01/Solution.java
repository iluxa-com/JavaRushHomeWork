package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        FileInputStream inFile = new FileInputStream(args[1]);
        FileOutputStream outFile = new FileOutputStream(args[2]);

        crypt(inFile,outFile);

        inFile.close();
        outFile.close();

    }

    private static void crypt(FileInputStream inFile, FileOutputStream outFile) throws IOException
    {
        while (inFile.available()>0){
            outFile.write(inFile.read()^3);
        }
    }


}
