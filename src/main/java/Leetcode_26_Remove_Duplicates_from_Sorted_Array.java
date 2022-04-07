package src.main.java;

public class Leetcode_26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        //[0,1,2,3,3,3,4,4,5]
        //[0,1,2,3,4,5,3,3,4]
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (i == 0 || nums[i-1] != nums[j]) {
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }
}