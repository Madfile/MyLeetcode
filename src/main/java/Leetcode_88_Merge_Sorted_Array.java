package src.main.java;

public class Leetcode_88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            nums1 = nums2;
            return;
        }

        if (nums2.length == 0) {
            return;
        }
        //[1,2,3,0,0,0] [2,5,6]
        //[1,2,2,3,5,6]
        //index for num1
        int i = 0;
        //index for num2
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                insert(nums2[j], nums1, i);
                i++;
                j++;
                m++;
            } else {
                i++;
            }
            //System.out.println(Arrays.toString(nums1));
        }

        //System.out.println("i reaches m");

        if (j < n) {
            while (j < n) {
                insert(nums2[j], nums1, i);
                i++;
                j++;
                //System.out.println(Arrays.toString(nums1));
            }
        }
    }

    private void insert(int num, int[] nums, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }

        nums[index] = num;
    }
}
