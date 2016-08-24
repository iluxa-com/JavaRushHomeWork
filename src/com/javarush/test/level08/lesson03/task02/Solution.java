package com.javarush.test.level08.lesson03.task02;

/* HashMap из 10 пар
Создать коллекцию HashMap<String, String>, занести туда 10 пар строк:
арбуз - ягода, банан - трава, вишня - ягода, груша - фрукт, дыня - овощ, ежевика - куст, жень-шень - корень, земляника - ягода, ирис - цветок, картофель - клубень.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Пример вывода (тут показана только одна строка):
картофель - клубень
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        HashMap<String,String> vegs = new HashMap<>();
        vegs.put("арбуз","ягода");
        vegs.put("банан","трава");
        vegs.put("вишня","ягода");
        vegs.put("груша","фрукт");
        vegs.put("дыня","овощ");
        vegs.put("ежевика","куст");
        vegs.put("жень-шень","корень");
        vegs.put("земляника","ягода");
        vegs.put("ирис","цветок");
        vegs.put("картофель","клубень");

        for(Map.Entry<String,String> pair : vegs.entrySet()){
            System.out.println(pair.getKey()+" - "+pair.getValue());
        }

    }
}
