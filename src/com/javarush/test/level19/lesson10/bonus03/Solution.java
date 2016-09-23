package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.TreeSet;


public class Solution {
    private static TreeSet<HtmlTag> tagList = new TreeSet<>();
    private static int nextStartingIndex = -1;
    private static int nextEndingIndex = -1;
    private static String html;

    public static void main(String[] args) throws IOException
    {
        HtmlTag.setMarker(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        html = getHtmlFromFile(fileName);

        setNextStartingIndex();
        setNextEndingIndex();

        while ((nextStartingIndex > 0) && (nextEndingIndex > 0))
        fillTagList(nextStartingIndex, nextEndingIndex);

        for (HtmlTag tag :
                tagList)
        {
            System.out.println(html.substring(tag.startPosition,tag.endPosition));
        }


    }

    private static void setNextEndingIndex()
    {
        nextEndingIndex = html.indexOf(HtmlTag.getClosingMarker(),nextEndingIndex+1);
    }

    private static void setNextStartingIndex()
    {
        nextStartingIndex = html.indexOf(HtmlTag.getOpeningMarker(),nextStartingIndex+1);
    }


    private static void fillTagList(int currStartingTagIndex, int currentEndingTagIndex)
    {
        setNextStartingIndex();
        while ((nextStartingIndex < currentEndingTagIndex) && (nextStartingIndex > 0)){
            fillTagList(nextStartingIndex,currentEndingTagIndex);
        }
        tagList.add(new HtmlTag(currStartingTagIndex,currentEndingTagIndex));
        setNextEndingIndex();
    }

    private static String getHtmlFromFile(String fileName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String result = "";

        while (bufferedReader.ready()){
            result = result + " " + bufferedReader.readLine();
        }

        bufferedReader.close();

        return result;
    }
}
