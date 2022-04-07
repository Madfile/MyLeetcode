package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        //3,4,5,1,2,0,2,3
        //2,4,5,1,2,0,3,3
        int i = 0;
        int j = nums.length - 1;

        while (j >= i) {
            if (nums[i] == val) {
                while (nums[j] == val && j > i) {
                    j--;
                }

                if (j == i) {
                    return i;
                }

                //[3,3] 3
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
                j--;
            } else {
                i++;
            }
        }

        return i;
    }
}