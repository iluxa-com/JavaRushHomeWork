package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String,String> map= createMap();
        removeTheFirstNameDuplicates(map);
        for(String key : map.keySet()){
            System.out.println(key);
        }
    }
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<>();

        map.put("Smith","John");
        map.put("Tyson","Ann");
        map.put("Klichko","Joseph");
        map.put("Valuev","Johan");
        map.put("Samual","Peter");
        map.put("Lenox","John");
        map.put("Aaaa","Ann");
        map.put("Bbbbb","Maria");
        map.put("Cccc","Maria");
        map.put("Fffff","John");
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        ArrayList<String> dublicates =new ArrayList<>();

        for(String name : map.values())
        {

            int nameCount=0;
            for (String dup: map.values()){
                if (dup.equals(name)) nameCount++;
            }
            if (nameCount>1) dublicates.add(name);

        }
        for(String name :dublicates) {
            removeItemFromMapByValue(map,name);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<>(map);
        for (HashMap.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
