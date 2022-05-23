package src.main.java;

import java.util.*;

public class LeetCode_20_Valid_Parentheses {
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> bracketMap = new HashMap<>();
            bracketMap.put(')', '(');
            bracketMap.put(']', '[');
            bracketMap.put('}', '{');

            Deque<Character> stack = new ArrayDeque<>();
            for (char c: s.toCharArray()) {
                if (!bracketMap.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.size() == 0) {
                        return false;
                    }
                    char candidate = stack.pop();
                    if (!(candidate == bracketMap.get(c))) return false;
                }
            }

            if (stack.size() != 0) return false;

            return true;
        }
    }
}

