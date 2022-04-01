package src.main.java;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_75_Sort_Colors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);

        for (Integer i: nums) {
            map.put(i, map.get(i) + 1);
        }

        int length = nums.length;

        int index = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[index] = entry.getKey();
                index++;
            }
        }
    }
}
