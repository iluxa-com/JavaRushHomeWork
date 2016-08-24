package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by user on 17.07.16.
 */
public class InterruptedThread extends Thread
{
    public void run(){
        while (true){
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("InterruptedException");
            }
        }
    }
}
