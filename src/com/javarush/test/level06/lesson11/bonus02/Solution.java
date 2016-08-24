package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так,
 чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа том
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа том, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа том
Cat name is дочь Пушинка, mother is мама Василиса, father is папа том
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String Name;

        Name= reader.readLine();
        Cat catGrandFa = new Cat(Name,null,null);

        Name= reader.readLine();
        Cat catGrandMa = new Cat(Name,null,null);

        Name= reader.readLine();
        Cat catFather = new Cat(Name,catGrandFa,null);

        Name= reader.readLine();
        Cat catMother = new Cat(Name,null,catGrandMa);

        Name= reader.readLine();
        Cat catSun = new Cat(Name,catFather,catMother);

        Name = reader.readLine();
        Cat catDaughter = new Cat(Name, catFather,catMother);

        System.out.println(catGrandFa);
        System.out.println(catGrandMa);
        System.out.println(catFather);
        System.out.println(catMother);


        System.out.println(catSun);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            String mothersName;
            String fathersName;
            if (mother == null)
                mothersName = ", no mother";
            else
                mothersName =", mother is " + mother.name;
            if (father == null)
                fathersName = ", no father";
            else
                fathersName =", father is " + father.name;

            return "Cat name is "+this.name+mothersName+fathersName;
        }
    }

}
