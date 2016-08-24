package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        HashSet<String> vegs = new HashSet<>();
        vegs.add("арбуз");
        vegs.add("банан");
        vegs.add("вишня");
        vegs.add("груша");
        vegs.add("дыня");
        vegs.add("ежевика");
        vegs.add("жень-шень");
        vegs.add("земляника");
        vegs.add("ирис");
        vegs.add("картофель");

        for(String e : vegs){
            System.out.println(e);
        }

    }
}
