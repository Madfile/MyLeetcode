public class Leetcode_191_Number_Of_1_Bits {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String str = Integer.toBinaryString(n);

            int result = 0;
            for (char c: str.toCharArray()) {
                if (c == '1') {
                    result++;
                }
            }

            return result;
        }
    }
}
