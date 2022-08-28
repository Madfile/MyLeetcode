import java.lang.reflect.Array;
import java.util.*;

public class Leetcode_383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }

        for (char c: ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c)) {
                return false;
            } else {
                if (magazineMap.get(c) == 0) return false;
            }

            magazineMap.put(c, magazineMap.get(c) - 1);
        }

        return true;
    }
}
