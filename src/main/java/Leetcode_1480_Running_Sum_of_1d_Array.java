public class Leetcode_1480_Running_Sum_of_1d_Array {
    class Solution {
        public int[] runningSum(int[] nums) {
            int[] res = new int[nums.length];
            int cur = 0;

            for (int i = 0; i < nums.length; i++) {
                cur += nums[i];
                res[i] = cur;
            }

            return res;
        }
    }
}
