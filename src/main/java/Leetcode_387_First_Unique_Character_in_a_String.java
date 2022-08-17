import java.util.HashMap;
import java.util.LinkedHashMap;

public class Leetcode_387_First_Unique_Character_in_a_String {
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer[]> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    Integer[] array = map.get(c);
                    array[1] = array[1] + 1;
                    map.put(c, array);
                } else {
                    map.put(c, new Integer[]{i, 0});
                }
            }

            for (char c: map.keySet()) {
                if (map.get(c)[1] == 0) return map.get(c)[0];
            }

            return -1;
        }
    }
}
