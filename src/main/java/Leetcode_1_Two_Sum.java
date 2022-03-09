package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }

        return new int[2];
    }

    //use hashmap to low down the complexity from O(n^2) to O(n)
    public int[] twoSum_Optimum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(map.containsKey(sub)&&map.get(sub)!=i){
                return new int[]{i,map.get(sub)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //combine the hashmap gen and the calculation
    public int[] twoSum_Fastest(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int sub=target-nums[i];
            if(map.containsKey(sub)){
                return new int[]{i,map.get(sub)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}