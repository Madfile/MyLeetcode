import java.util.PriorityQueue;

public class Leetcode_1029_Two_City_Scheduling {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int sum = 0;
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1]) - (a[0] - b[0]));

            for (int[] cost: costs) {
                heap.offer(cost);
                sum += cost[0];
            }

            for (int i = 0; i < costs.length/2; i++) {
                int[] cost = heap.poll();
                sum += cost[1] - cost[0];
            }

            return sum;
        }
    }
}
