package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human gm1 = new Human("gm1",false,56);
        Human gm2 = new Human("gm2",false,54);
        Human gp1 = new Human("gp1",true,57);
        Human gp2 = new Human("gp2",true,60);
        Human ma = new Human("ma",false,30);
        Human pa = new Human("pa",true,34);
        Human kid1 = new Human("kid1",true,5);
        Human kid2 = new Human("kid2",false,4);
        Human kid3 = new Human("kid3",false,2);

        gm1.children.add(ma);
        gp1.children.add(ma);

        gm2.children.add(pa);
        gp2.children.add(pa);

        ma.children.add(kid1);
        ma.children.add(kid2);
        ma.children.add(kid3);

        pa.children.add(kid1);
        pa.children.add(kid2);
        pa.children.add(kid3);

        System.out.println(gm1);
        System.out.println(gm2);

        System.out.println(gp1);
        System.out.println(gp2);

        System.out.println(ma);
        System.out.println(pa);

        System.out.println(kid1);
        System.out.println(kid2);
        System.out.println(kid3);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
