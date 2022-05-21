import java.util.*;

public class Leetcode_743_Network_Delay_Time {
    public int networkDelayTime(int[][] times, int n, int k) {
        //construct graph
        Map<Integer, List<Cell>> graph = new HashMap<>();
        for (int[] time: times) {
            List<Cell> edges = graph.getOrDefault(time[0], new ArrayList<>());
            edges.add(new Cell(time[1], time[2]));
            //can comment out?
            graph.put(time[0], edges);
        }

        Map<Integer, Integer> costs = new HashMap<>();
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        heap.offer(new Cell(k, 0));
        while(!heap.isEmpty()) {
            Cell cur = heap.poll();
            if (costs.containsKey(cur.node)) continue;
            costs.put(cur.node, cur.time);
            if (graph.containsKey(cur.node)) {
                for (Cell cell: graph.get(cur.node)) {
                    if (!costs.containsKey(cell.node)) {
                        heap.offer(new Cell(cell.node, cur.time + cell.time));
                    }
                }
            }
        }
        if (costs.size() != n) {
            return -1;
        }
        int result = 0;
        for (int x: costs.values()) {
            result = Math.max(result, x);
        }

        return result;
    }

    class Cell implements Comparable<Cell> {
        int node, time;
        Cell (int node, int time) {
            this.node = node;
            this.time = time;
        }

        public int compareTo(Cell c2) {
            return time - c2.time;
        }
    }
}
