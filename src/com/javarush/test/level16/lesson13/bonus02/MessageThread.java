package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by user on 17.07.16.
 */
public class MessageThread extends Thread implements Message
{
    @Override
    public void showWarning()
    {
        Thread.currentThread().interrupt();
    }

    public void run(){
        while (true){
            if (Thread.currentThread().isInterrupted()) break;
        }
    }
}
