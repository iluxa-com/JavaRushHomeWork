package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        Person person;
        String name;
        String sex;
        String bd;


        switch (args[0]){
            case "-c":
                if (args.length == 4)
                {
                    name = args[1];
                    sex = args[2];
                    bd = args[3];
                }
                else {
                    name = args[1] + " " + args[2];
                    sex = args[3];
                    bd = args[4];
                }

                person = createPerson(name,sex,bd);
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                break;
            case "-u":
                if (args.length == 5)
                {
                    name = args[2];
                    sex = args[3];
                    bd = args[4];
                }
                else {
                    name = args[2] + " " + args[3];
                    sex = args[4];
                    bd = args[5];
                }
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(name);
                if (sex.equals("м")) person.setSex(Sex.MALE);
                else person.setSex(Sex.FEMALE);
                person.setBirthDay(getDate(bd));
                break;
            case "-d":
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
                break;
            case "-i":
                person = allPeople.get(Integer.parseInt(args[1]));
                printPersonInfo(person);
                break;
            default:
                System.out.println("incorrect arguments set");
        }
    }

    private static void printPersonInfo(Person person)
    {
        String sex = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (person.getSex().equals(Sex.MALE))  sex = "м";
        else sex = "ж";
        System.out.println(person.getName() + " " + sex + " " + simpleDateFormat.format(person.getBirthDay()));
    }

    private static Person createPerson(String name,String sex, String date)
    {
        Person person;
        if (sex.equals("м")) person = Person.createMale(name,getDate(date));
        else person = Person.createFemale(name,getDate(date));
        return person;
    }

    private static Date getDate(String arg)
    {
        Date date =null ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        try
        {
            date = simpleDateFormat.parse(arg);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
}
