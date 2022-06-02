import java.util.HashSet;

public class Leetcode_3_Longest_Substring_Without_Repeating_Characters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            HashSet<Character> appeared = new HashSet<>();
            //int pos = 0;
            int length = 1;

            for (int i = 0; i < s.length(); i++) {
                appeared.clear();
                appeared.add(s.charAt(i));
                int newLength = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    //System.out.println("i: " + i + " & j: " + j);
                    //System.out.println("newLength: " + newLength);
                    //System.out.println("HashSet: " + appeared);
                    if (appeared.contains(s.charAt(j))) {
                        break;
                    } else {
                        newLength++;
                        appeared.add(s.charAt(j));
                    }
                }

                length = Math.max(length, newLength);
            }

            return length;
        }
    }
}
