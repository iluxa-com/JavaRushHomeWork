package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    @Override
    public void write(String s, int i, int i1) throws IOException
    {
        super.write(s, i, i1);
        System.out.println(s.substring(i,i1));
    }

    @Override
    public void write(int i) throws IOException
    {
        super.write(i);
        System.out.println(((char)i));
    }

    @Override
    public void write(char[] chars, int i, int i1) throws IOException
    {
        super.write(chars, i, i1);
        for (int j = i; j < i + i1 ; j++)
        {
            System.out.println(chars[j]);
        }
        System.out.println();
    }

    @Override
    public void write(char[] chars) throws IOException
    {
        super.write(chars);
        System.out.println(chars);
    }

    @Override
    public void write(String s) throws IOException
    {
        super.write(s);
        System.out.println(s);
    }

    public FileConsoleWriter(String s) throws IOException
    {
        super(s);
    }

    public FileConsoleWriter(String s, boolean b) throws IOException
    {
        super(s, b);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean b) throws IOException
    {
        super(file, b);
    }

    public FileConsoleWriter(FileDescriptor fileDescriptor)
    {
        super(fileDescriptor);
    }
}
