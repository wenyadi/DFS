package com.codeReview.DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList <String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    public void helper(char[] array, int index, List<String> result) {
        // termination condition: only we have already chosen the characters for all position, we can have a complete permutation
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            swap(array, index, i);
        }
    }

    public void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
