package com.javarush.test.level20.lesson10.bonus02;

/**
 * Created by user on 09.11.16.
 */
public class Rectangle
{
    int startX, endX, startY, endY;

    public Rectangle(int startX, int endX, int startY, int endY)
    {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public boolean contains(int i, int j)
    {
        return startX<=i && endX >= i && startY <=j && endY >= j;
    }

    public boolean isPointNextTo(int i, int j)
    {
        return this.contains(i-1,j) || this.contains(i,j-1);
    }

    public void expandWith(int i, int j)
    {
        if (i > endX) endX++;
        if (j > endY) endY++;
    }
}
