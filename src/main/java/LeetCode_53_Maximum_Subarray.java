package src.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeetCode_53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int globalSum = Integer.MIN_VALUE;
        int localSum = 0;

        for (int i = 0; i < nums.length; i++) {
            localSum = nums[i] + localSum;
            if (localSum < nums[i]) {
                localSum = nums[i];
            }

            globalSum = Math.max(globalSum, localSum);
        }

        return globalSum;
    }
}
