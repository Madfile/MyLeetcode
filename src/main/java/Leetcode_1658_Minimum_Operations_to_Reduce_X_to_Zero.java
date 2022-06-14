public class Leetcode_1658_Minimum_Operations_to_Reduce_X_to_Zero {
    // class Solution {
//     public int minOperations(int[] nums, int x) {
//         int target = 0;
//         int len = nums.length;
//         for (int num : nums) {
//             target += num;
//         }
//         // corner case
//         // 如果整个数组的和 == X，说明需要移除所有元素
//         if (target == x) {
//             return len;
//         }

//         // normal case
//         // target = totalSum - x
//         target -= x;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);
//         int res = Integer.MIN_VALUE;
//         int sum = 0;
//         for (int i = 0; i < len; i++) {
//             sum += nums[i];
//             if (map.containsKey(sum - target)) {
//                 res = Math.max(res, i - map.get(sum - target));
//             }
//             map.put(sum, i);
//         }
//         return res == Integer.MIN_VALUE ? -1 : len - res;
//     }
// }

    class Solution {
        public int minOperations(int[] nums, int x) {

            //sliding window approach

            int sum=0;
            for (int num : nums) sum += num;
            int target=sum-x;

            int max=Integer.MIN_VALUE;
            if(target==0)       //if array sum is equal to x ,return length
                return nums.length;
            if(target<0)        //if target is not possible return -1
                return -1;
            sum=0;
            int j=0;              // variable storing no. of elements to exclude from the left of the subarray so we can achieve                                      our target sum
            for(int i=0;i<nums.length;i++){

                sum+=nums[i];
                while(sum>target){      // when the prefix sum becomes larger than target then we need to exclude elements from the left and increment j
                    sum-=nums[j];
                    j++;
                }
                if(sum==target)
                    max=Math.max(max,i-j+1);

            }
            if(max==Integer.MIN_VALUE)
                return -1;
            else
                return nums.length-max;         // since the no. of operations required is length of original array - length of subarray whose sum equals to target
            // and to minimise the operations we need to maximize the length of the subarray
        }
    }
}
