package com.chung;

import java.util.List;

public class InsertionSort {

    public InsertionSort()
    {
        System.out.println("Calling InsertionSort class...\n");
    }

    public static void sort(List<Integer> list)
    {
        int n = list.size();
        for (int i = 1; i < n; ++i)
        {
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key)
            {
                list.set(j+1, list.get(j));
                j = j-1;
            }
            list.set(j+1, key);
        }
    }

}
