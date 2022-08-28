public class Leetcode_326_Power_of_Three {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 0) return false;
            if ((int)(Math.log10(n) / Math.log10(3)) != Math.log10(n) / Math.log10(3.0)) return false;

            return true;
        }
    }
}
