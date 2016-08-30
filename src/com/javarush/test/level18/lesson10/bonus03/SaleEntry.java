package com.javarush.test.level18.lesson10.bonus03;

import java.util.TreeSet;

/**
 * Created by user on 28.08.16.
 */
public class SaleEntry implements Comparable<SaleEntry>
{
    @Override
    public String toString()
    {
        return format(Long.toString(id), 8)
                + format(productName, 30)
                + format(Double.toString(price), 8)
                + format(Integer.toString(quantity), 4);
    }

    private long id;
    private String productName = "";
    private double price;
    private  int quantity;

    public SaleEntry(String[] array){
        id = Long.parseLong(array[0].trim());
        for (int i = 1; i < array.length-2; i++)
            productName = productName + array[i] + " ";
        price = Double.parseDouble(array[array.length-2]);
        quantity = Integer.parseInt(array[array.length-1].trim());
    }

    public SaleEntry(int id){
        this.id = id;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof SaleEntry)) return false;

        SaleEntry saleEntry = (SaleEntry) o;

        return id == saleEntry.id;

    }

    @Override
    public int hashCode()
    {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public int compareTo(SaleEntry saleEntry)
    {
        if (id < saleEntry.id) return -1;
        else if (id > saleEntry.id) return 1;
        return 0;
    }

    private static String format(String str, int length)
    {
        if (str.length() > length) return str.substring(0,length);
        else return String.format("%-" + length + "s", str);
    }
}
