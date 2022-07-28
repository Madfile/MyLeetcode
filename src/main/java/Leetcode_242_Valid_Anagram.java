import java.util.HashMap;
import java.util.Map;

public class Leetcode_242_Valid_Anagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();

            Map<Character, Integer> charMap = new HashMap<>();
            for (Character c: chars1) {
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            }

            for (Character c: chars2) {
                if (charMap.containsKey(c)) {
                    int value = charMap.get(c);
                    if (value == 1) {
                        charMap.remove(c);
                    } else {
                        charMap.put(c, value - 1);
                    }
                } else {
                    return false;
                }
            }

            if (charMap.size() != 0) return false;

            return true;
        }
    }
}
