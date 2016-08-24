package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String,Date> map;
        map = createMap();
        removeAllSummerPeople(map);

        for (String key : map.keySet()){
            System.out.println(key);
        }
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("AUGUST 1 1980"));
        map.put("Stallone3", new Date("MAY 1 1980"));
        map.put("Stallone4", new Date("JANUARY 1 1980"));
        map.put("Stallone5", new Date("DECEMBER 1 1980"));
        map.put("Stallone6", new Date("OCTOBER 1 1980"));
        map.put("Stallone7", new Date("JULY 1 1980"));
        map.put("Stallone8", new Date("FEBRUARY 1 1980"));
        map.put("Stallone9", new Date("SEPTEMBER 1 1980"));
        map.put("Stallone10", new Date("JUNE 14 1980"));

        //напишите тут ваш код


        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        ArrayList<String> keysToDDelete = new ArrayList<>();

        for (Map.Entry<String,Date> entry : map.entrySet()){
            if (entry.getValue().getMonth()>4 && entry.getValue().getMonth()<8)
                keysToDDelete.add(entry.getKey());

        }

        for(String key : keysToDDelete){
            map.remove(key);

        }

    }
}
