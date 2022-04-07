package src.main.java;

public class Leetcode_35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        return binarySearch(0, nums.length - 1, target, nums);

    }

    private int binarySearch(int i, int j, int target, int[] nums) {

        if (j - i <= 1) {
            // System.out.println(" <=1");
            if (target == nums[i]) {
                return i;
            } else {
                return j;
            }
        }

        int mid = (j + i) / 2;
        // System.out.println("mid: "+mid);
        // System.out.println("i: "+i);
        // System.out.println("j: "+j);

        if (target >= nums[i] && target < nums[mid]) {
            return binarySearch(i, mid, target, nums);
        } else {
            return binarySearch(mid, j, target, nums);
        }
    }
}
