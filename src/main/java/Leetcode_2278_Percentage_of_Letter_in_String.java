public class Leetcode_2278_Percentage_of_Letter_in_String {
    class Solution {
        public int percentageLetter(String s, char letter) {
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letter) {
                    num++;
                }
            }

            return (int)((double)num / (s.length()) * 100);
        }
    }
}
