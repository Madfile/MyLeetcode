import java.util.Arrays;

public class Leetcode_2279_Maximum_Bags_With_Full_Capacity_of_Rocks {
    class Solution {
        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            Integer[] left = new Integer[capacity.length];
            for (int i = 0; i < capacity.length; i++) {
                left[i] = capacity[i] - rocks[i];
            }

            //Arrays.sort(left, Collections.reverseOrder());
            Arrays.sort(left);
            //System.out.println(Arrays.toString(left));
            int index = 0;
            while(additionalRocks > 0 && index < left.length) {
                while (index < left.length && left[index] == 0) {
                    index++;
                }

                if(index < left.length) {
                    if (additionalRocks >= left[index]) {
                        additionalRocks -= left[index];
                        left[index] = 0;
                    } else {
                        left[index] -= additionalRocks;
                        break;
                    }
                }
            }

            int result = 0;
            //System.out.println(Arrays.toString(left));

            for (int i = 0; i < left.length; i++) {
                if (left[i] == 0) {
                    result++;
                } else break;
            }

            return result;
        }
    }
}
