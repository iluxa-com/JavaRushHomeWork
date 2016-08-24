package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by user on 21.06.16.
 */
public class Singleton
{
    private static Singleton singleton;

    public static Singleton getInstance(){
        if (singleton!=null) return singleton;
        else return singleton = new Singleton();
    }
    private Singleton(){}
}
