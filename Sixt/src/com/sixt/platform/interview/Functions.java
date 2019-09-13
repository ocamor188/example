package com.sixt.platform.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Functions {

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

    public boolean areAnagrams(String one, String two) {
        Map<String, Integer> map = new HashMap<>();
        String[] left = one.toUpperCase().replaceAll("\\s", "").split("");
        String[] right = two.toUpperCase().replaceAll("\\s", "").split("");

        for (String c : left)
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);

            } else {
                map.put(c, 1);
            }
        for (String c : right)
            if (!map.containsKey(c)) {
                return false;
            }else {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0)
                    map.remove(c);
            }

        return map.isEmpty();
    }
}
