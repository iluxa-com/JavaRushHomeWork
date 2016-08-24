package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 17.07.16.
 */
public class Summizer extends Thread
{
    public void run(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sum=0;
        String line;
        while (true)
        {
            try
            {
                line = bufferedReader.readLine();

                if (line.equals("N")) break;
                sum = sum + Integer.parseInt(line);
            }
            catch (Exception e)
            {
//                e.printStackTrace();
                break;
            }

        }

        System.out.println(sum);
        try
        {
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
