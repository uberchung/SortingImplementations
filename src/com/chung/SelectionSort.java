package com.chung;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SelectionSort {

    public static void sort(@NotNull List<Integer> list)
    {
        int size = list.size();

        for (int item = 0; item < size - 1; item++)
        {
            int minimum = item;
            for (int number = minimum + 1 ; number < size; number++)
            {
                if (list.get(number) < list.get(minimum))
                {
                    minimum = number;
                }
            }
            int temporary = list.get(item);
            list.set(item, list.get(minimum));
            list.set(minimum, temporary);
        }
    }
}
