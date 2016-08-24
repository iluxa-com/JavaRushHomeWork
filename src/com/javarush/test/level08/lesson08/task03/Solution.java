package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<>();
        //напишите тут ваш код
        for (int i = 0; i < 10; i++)
        {
            map.put("lastname"+i, "name"+i);
        }
        return  map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int namesakeCount=0;
        //напишите тут ваш код
        for (Map.Entry<String,String> entry : map.entrySet()){
            if (entry.getValue().equals(name)) namesakeCount++;
        }
        return  namesakeCount;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int namesakeCount=0;
        //напишите тут ваш код
        for (Map.Entry<String,String> entry : map.entrySet()){
            if (entry.getKey().equals(lastName)) namesakeCount++;
        }
        return  namesakeCount;
    }
}
