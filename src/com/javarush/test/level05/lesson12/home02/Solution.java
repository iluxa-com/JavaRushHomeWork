package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1=new Man("Vasia", 14,"ul Lenina 5");
        Man man2=new Man("Petya", 16,"ul Lenina 8");
        Woman woman1= new Woman("Masha", 16,"ul Lenina 9");
        Woman woman2= new Woman("Ira", 13,"ul Lenina 3");

        System.out.println(man1.name+" "+man1.age+" "+man1.address);
        System.out.println(man2.name+" "+man2.age+" "+man2.address);
        System.out.println(woman1.name+" "+woman1.age+" "+woman1.address);
        System.out.println(woman2.name+" "+woman2.age+" "+woman2.address);



        //выведи их на экран тут
    }

    public static class Man
    {
        String name;
        int age;
        String address;

        public Man(String name)
        {
            this.name = name;
        }

        public Man(String name, int age)
        {
            this.age = age;
            this.name = name;
        }

        public Man(String name, int age, String address)
        {
            this.age = age;
            this.name = name;
            this.address = address;
        }

    }
    public static class Woman
    {
        String name;
        int age;
        String address;

        public Woman(String name)
        {
            this.name = name;
        }

        public Woman(String name, int age)
        {
            this.age = age;
            this.name = name;
        }

        public Woman(String name, int age, String address)
        {
            this.age = age;
            this.name = name;
            this.address = address;
        }
    }




    //добавьте тут ваши классы
}
