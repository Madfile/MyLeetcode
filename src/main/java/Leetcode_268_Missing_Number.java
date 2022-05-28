import java.util.Arrays;

public class Leetcode_268_Missing_Number {
    class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != i) return i;
//         }

//         return nums.length;
//     }

        public int missingNumber(int[] nums) {
            // Arrays.sort(nums);
            // for (int i = 0; i < nums.length; i++) {
            //     if (nums[i] != i) return i;
            // }

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }

            int n = nums.length + 1;

            return (n - 1) * n / 2 - sum;
        }
    }
}
