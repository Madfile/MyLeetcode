import java.util.ArrayList;
import java.util.List;

public class Leetcode_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    //My solution
//    List<Integer> result = new ArrayList<>();
//
//    public int[] searchRange(int[] nums, int target) {
//        //nums = [5,7,7,8,8,10], target = 8
//        //[3,4]
//        binaryDoubleSearch(0, nums.length - 1, nums, target);
//
//        result.sort((a,b) -> a - b);
//        if (result.size() == 0) return new int[]{-1,-1};
//        return result.stream().mapToInt(i -> i).toArray();
//    }
//
//    private void binaryDoubleSearch(int left, int right, int[] nums, int target) {
//        if (left > right) return;
//        if (left == right) {
//            if (nums[left] == target) result.add(left);
//            return;
//        }
//
//        int mid = left + (right - left) / 2;
//        if (nums[mid] == target) {
//            if (mid > 0 && nums[mid - 1] == target) {
//                binaryDoubleSearch(0, mid - 1, nums, target);
//            }
//            result.add(mid);
//            if (mid < nums.length - 1 && nums[mid + 1] == target) {
//                binaryDoubleSearch(mid + 1, nums.length - 1, nums, target);
//            }
//        } else if (nums[mid] < target && mid > 0) {
//            binaryDoubleSearch(0, mid - 1, nums, target);
//        } else {
//            if (mid < nums.length - 1) binaryDoubleSearch(mid + 1, nums.length - 1, nums, target);
//        }
//    }
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] ans = { -1, -1 };
        if (nums.length == 0) {
            return ans;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        //考虑 tartget 是否存在，判断我们要找的值是否等于 target 并且是否越界
        if (start == nums.length || nums[ start ] != target) {
            return ans;
        } else {
            ans[0] = start;
        }
        ans[0] = start;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans[1] = end;
        return ans;
    }
}
