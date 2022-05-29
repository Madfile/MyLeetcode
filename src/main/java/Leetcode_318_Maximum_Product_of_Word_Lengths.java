import java.util.Arrays;

public class Leetcode_318_Maximum_Product_of_Word_Lengths {
    class Solution {
        public int maxProduct(String[] words) {
            Arrays.sort(words, (a, b) -> b.length() - a.length());
            int result = 0;

            for (int i = 0; i < words.length - 1; i++) {
                int len = 0;
                for (int j = i + 1; j < words.length; j++) {
                    if (!hasSameLetter(words[i], words[j]) && words[j].length() > len) {
                        len = words[j].length();
                        break;
                    }
                }

                int newLen = words[i].length() * len;
                if (newLen > result) result = newLen;
            }

            return result;
        }

        private boolean hasSameLetter(String str1, String str2) {
            char[] char2 = str2.toCharArray();
            for (char c1: str1.toCharArray()) {
                for (char c2: char2) {
                    if (c1 == c2) return true;
                }
            }

            return false;
        }
    }
}
