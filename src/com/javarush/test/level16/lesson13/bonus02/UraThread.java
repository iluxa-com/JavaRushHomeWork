package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by user on 17.07.16.
 */
public class UraThread extends Thread
{
    public void run(){
    while (true){
        System.out.println("Ура");
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
//            e.printStackTrace();
        }
    }
}
}
