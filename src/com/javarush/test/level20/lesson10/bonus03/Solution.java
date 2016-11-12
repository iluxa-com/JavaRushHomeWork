package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        System.out.println(detectAllWords(crossword, "same", "moe","nloo","ooreo", "oemasu", "home",  "ppmluf", "opre"));
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        ArrayList<Word> list = new ArrayList<>();

        for (String word :
                words)
        {
            list.add(detectWord(crossword, word));
        }

        return list;
    }

    private static Word detectWord(int[][] crossword, String word)
    {
        for (int i =0 ; i < crossword.length; i++)
        {
            for (int j = 0; j < crossword[i].length; j++){
             if ( word.toCharArray()[0] == crossword[i][j])  {

                 int direction = Arrays.asList(getAllWordsStartingFromThePoint(crossword,i,j,word.length())).indexOf(word);

                 if (direction > -1)
                 {
                     Word w = new Word(word);
                     w.setStartPoint(j, i);

                     switch (direction)
                     {
                         // to the right
                         case 0:
                             w.setEndPoint(j + word.length() - 1, i);
                             break;
                         //to the bottom-right
                         case 1:
                             w.setEndPoint(j + word.length() - 1, i + word.length() - 1);
                             break;
                         //to the bottom
                         case 2:
                             w.setEndPoint(j, i + word.length() - 1);
                             break;
                         case 3:
                             w.setEndPoint(j - word.length() + 1, i + word.length() - 1);
                             break;
                         case 4:
                             w.setEndPoint(j - word.length() + 1, i);
                             break;
                         case 5:
                             w.setEndPoint(j - word.length() + 1, i - word.length() + 1);
                             break;
                         case 6:
                             w.setEndPoint(j, i - word.length() + 1);
                             break;
                         case 7:
                             w.setEndPoint(j + word.length() - 1, i - word.length() + 1);
                             break;
                     }

                     return w;
                 }
             }
            }
        }

        return null;
    }

    private static String[] getAllWordsStartingFromThePoint(int[][] crossword, int i, int j, int length)
    {
        String[] words = {"","","","","","","",""};


        for (int k = 0; k < length; k++){
            try
            {
                words[0] = words[0] + (char)crossword[i][j + k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[1] = words[1] + (char)crossword[i+k][j + k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[2] = words[2] + (char)crossword[i+k][j];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[3] = words[3] + (char)crossword[i + k][j - k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[4] = words[4] + (char)crossword[i][j - k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[5] = words[5] + (char)crossword[i - k][j - k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[6] = words[6] + (char)crossword[i - k][j];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
            try
            {
                words[7] = words[7] + (char)crossword[i - k][j + k];
            }
            catch (IndexOutOfBoundsException e)
            {
            }
        }
        return words;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
