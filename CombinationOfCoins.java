package com.codeReview.DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
    public List <List <Integer>> combinations(int target, int[] coins) {
        // Write your solution here.
        List <List <Integer>> result = new ArrayList <List <Integer>>();
        List <Integer> cur = new ArrayList <Integer>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    public void helper(int target, int[] coins, int index, List <Integer> cur, List <List <Integer>> result) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList <Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}


