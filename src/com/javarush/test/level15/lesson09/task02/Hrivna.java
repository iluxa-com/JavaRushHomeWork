package com.javarush.test.level15.lesson09.task02;

import com.javarush.test.level14.lesson08.home09.Money;

/**
 * Created by user on 23.06.16.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
