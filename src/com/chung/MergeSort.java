package com.chung;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size()/2;
        return merged(
                sort(list.subList(0, mid)),
                sort(list.subList(mid, list.size())));
    }

    private static List<Integer> merged(List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Integer> merged = new ArrayList<Integer>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }
}