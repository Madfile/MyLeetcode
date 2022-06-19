public class Leetcode_6099_Longest_Binary_Subsequence_Less_Than_or_Equal_to_K {
    class Solution {
        public int longestSubsequence(String s, int k) {
            StringBuilder sub = new StringBuilder();
            for (char c: s.toCharArray()) {
                if (c == '0') {
                    sub.append("0");
                }
            }

            StringBuilder tmp =new StringBuilder(s);
            tmp.reverse();
            s =  tmp.toString();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sub.insert(sub.length() - i, '1');
                    if (binaryToInteger(sub.toString()) > k) {
                        return sub.length() - 1;
                    }
                }
            }

            return sub.length();
        }

        public int binaryToInteger(String binary) {
            char[] numbers = binary.toCharArray();
            int result = 0;
            for(int i=numbers.length - 1; i>=0; i--)
                if(numbers[i]=='1')
                    result += Math.pow(2, (numbers.length-i - 1));
            return result;
        }
    }
}
