package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_13_Roman_to_Integer {
    public int romanToInt(String s) {
        Map<Character, Integer> valueMap = new HashMap<Character, Integer>();

        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            int currentValue = valueMap.get(s.charAt(i));
            int previousValue = valueMap.get(s.charAt(i - 1));
            if (currentValue > previousValue) {
                result -= previousValue;
            } else {
                result += previousValue;
            }
        }

        result += valueMap.get(s.charAt(s.length() - 1));

        return result;
    }
}
