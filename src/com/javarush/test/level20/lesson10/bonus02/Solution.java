package com.javarush.test.level20.lesson10.bonus02;

import java.util.ArrayList;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    private static ArrayList<Rectangle> rectangles = new ArrayList<>();

    public static int getRectangleCount(byte[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j< a[i].length;j++){
                if (a[i][j] == 1) findCorrespondingRectangle(i,j);
            }
        }
        return rectangles.size();
    }

    private static void findCorrespondingRectangle(int i, int j)
    {
        boolean isLocated = false;
        for (Rectangle rect :
                rectangles)
        {
            if (rect.contains(i, j)){
                isLocated = true;
                break;
            }
            if (rect.isPointNextTo(i,j)){
                rect.expandWith(i,j);
                isLocated = true;
            }
        }

        if (!isLocated) rectangles.add(new Rectangle(i,i,j,j));
    }
}
