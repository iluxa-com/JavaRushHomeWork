package com.javarush.test.level18.lesson10.bonus03;

import java.io.*;
import java.util.TreeSet;

/**
 * Created by user on 30.08.16.
 */
public class SaleEntrySet
{
    private TreeSet<SaleEntry> set;

    public void update(SaleEntry saleEntry){
            set.remove(saleEntry);
            set.add(saleEntry);
    }

    public void remove(int id){
        SaleEntry saleEntry = new SaleEntry(id);
        if (set.contains(saleEntry)) set.remove(saleEntry);
    }

    public  SaleEntrySet(String fileName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String[] saleEntry = new String[4];
        String line;
        Long currentId;
        this.set = new TreeSet<>();

        while ((line=bufferedReader.readLine()) != null) {
            saleEntry[0] = line.substring(0, 8);
            saleEntry[1] = line.substring(8,38);
            saleEntry[2] = line.substring(38,46);
            saleEntry[3] = line.substring(46);

            SaleEntry saleEntryObj = new SaleEntry(saleEntry);

           set.add(saleEntryObj);

        }
        bufferedReader.close();
    }

    public void saveToFile (String fileName) throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

        for (SaleEntry entry :
                set)
        {
            bufferedWriter.write(entry.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

    }


}
