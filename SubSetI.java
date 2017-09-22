package com.codeReview.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yadiwen on 2017/6/12.
 */
public class SubSetI {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // at each level, determine the character at the position "Index" to picked up or not.
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // index 是代表当前递归调用的层数
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }

        // not picked
        helper(set, sb, index + 1, result);
        //picked
        helper(set, sb.append(set[index]), index + 1, result);
        //remove the add character when back tracking to the previous level.
        sb.deleteCharAt(sb.length() - 1);
        //给 stringbuilder 做一个清理
        /*
        for (int i = 0; i < 2; ++i ) {
            if (i == 0 ) {
            helper(set, sb, index + 1, result);
            } else {
                helper(set, sb.append(set[inded]), index + 1, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        Time complexity = O(2^(n+1) - 1)
         */
    }
}

