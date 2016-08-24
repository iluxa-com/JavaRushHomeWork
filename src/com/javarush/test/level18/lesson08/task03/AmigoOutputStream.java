package com.javarush.test.level18.lesson08.task03;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream {
    private FileOutputStream fileOutputStream;

    public static String fileName = "/home/user/text55.txt";

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException
    {

        this.fileOutputStream = fileOutputStream;
    }




    public void close() throws IOException
    {
        fileOutputStream.flush();
        fileOutputStream.write("JavaRush © 2012-2013 All rights reserved".getBytes());
        fileOutputStream.close();
    }


    public void write(byte[] bytes) throws IOException
    {
        fileOutputStream.write(bytes);
    }

    public static void main(String[] args) throws IOException
    {
        AmigoOutputStream amigoOutputStream = new AmigoOutputStream(new FileOutputStream(fileName));
        amigoOutputStream.write("some text\n".getBytes());
        amigoOutputStream.close();

    }

}

