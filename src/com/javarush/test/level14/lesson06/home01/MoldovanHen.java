package com.javarush.test.level14.lesson06.home01;

/**
 * Created by user on 20.06.16.
 */
public class MoldovanHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 3;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
