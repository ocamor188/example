package com.sixt.platform.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Functions {

    //this option is O(n2) consumes more memory
    public boolean isAnagram(String lhs, String rhs) {
        //both strings in the same way to compare, so same case in this case upper case, no whitespaces
        String[] left = lhs.toUpperCase().replaceAll("\\s", "").split("");
        String[] right = rhs.toUpperCase().replaceAll("\\s", "").split("");
        //first validation if they are different length we don't need to sort the arrays.Save memory
        if (left.length != right.length) {
            return false;
        }
        //sort the strings
        Arrays.sort(left);
        Arrays.sort(right);
        //return if they are equals or not.
        return Arrays.equals(left, right);
    }

    //This option is O(n)
    public boolean isAnagramBestOption(String lhs, String rhs) {
        Map<String, Integer> map = new HashMap<>();
        String[] left = lhs.toUpperCase().replaceAll("\\s", "").split("");
        String[] right = rhs.toUpperCase().replaceAll("\\s", "").split("");

        //Evaluates left side, so it is incrementing
        for (String charToEvaluate : left)
            if (map.containsKey(charToEvaluate)) {
                map.put(charToEvaluate, map.get(charToEvaluate) + 1);

            } else {
                map.put(charToEvaluate, 1);
            }
        //Evaluates right side, so it is decrementing
        for (String charToEvaluate : right)
            if (!map.containsKey(charToEvaluate)) {
                return false;
            }else {
                map.put(charToEvaluate, map.get(charToEvaluate) - 1);

                if (map.get(charToEvaluate) == 0) {
                    map.remove(charToEvaluate);
                }
            }

        return map.isEmpty();
    }
}
