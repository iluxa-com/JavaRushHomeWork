package com.javarush.test.level20.lesson10.bonus01;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static void main(String[] args)
    {

        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();

        for (int i :
                getNumbers(1118209))
        {
            if (i > 0 )
            System.out.println(i);
        }


        //int[]result = getNumbers(100000000);
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
    }
    public static int[] getNumbers(int N) {
        int[] result = new int[100];
        int numsCount = 0;
        double sum = 0;

        for (int i = 1; i < N; i++)
        {
            sum = 0;
            String nums = ((Integer) i).toString();

            for (char num :
                    nums.toCharArray())
            {
                int n = Character.getNumericValue(num);
                sum = sum + Math.pow(n, nums.length());
            }


            if (sum == (double) i)
            {
                result[numsCount] = i;
                numsCount++;
            }
        }

        return result;
    }
}
