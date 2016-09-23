package com.javarush.test.level19.lesson10.bonus03;

/**
 * Created by user on 21.09.16.
 */
class HtmlTag implements Comparable
{
    int startPosition;
    int endPosition;

    private static String openingMarker;
    private static String closingMarker;

    static void setMarker(String tagMarker)
    {
        closingMarker = "</" + tagMarker + ">";
        openingMarker = "<" + tagMarker;
    }


    HtmlTag(int start, int end)
    {
        this.startPosition = start;
        this.endPosition = end + closingMarker.length();
    }

    static String getOpeningMarker()
    {

        return openingMarker;
    }

    static String getClosingMarker()
    {
        return closingMarker;
    }


    @Override
    public int compareTo(Object o)
    {
        if (this.startPosition < ((HtmlTag)o).startPosition)
            return -1;
        else if (this.startPosition > (((HtmlTag) o).startPosition))
            return 1;
        else return 0;
    }
}
