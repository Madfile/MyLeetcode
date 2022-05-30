import java.util.*;

public class Leetcode_787_Cheapest_Flights_Within_K_Stops {
//    public static void main(String[] args) {
//        System.out.println(findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
//    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int result = -1;
        //construct graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight: flights) {
            List<int[]> edges = graph.getOrDefault(flight[0], new ArrayList<int[]>());
            edges.add(new int[]{flight[1], flight[2]});
            graph.put(flight[0], edges);
        }

        //do BFS
        // PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[1] - o2[1];
        //     }
        // });

        Queue<int[]> heap = new LinkedList<>();

        Map<Integer, Integer> cost = new HashMap<>();
        //Set<Integer> visited = new HashSet<>();
        heap.offer(new int[]{src, 0});

        k++;

        while(!heap.isEmpty() && k != 0) {
            int size = heap.size();
            for (int i = 0; i < size; i++) {
                int[] cityCost = heap.poll();
                int city = cityCost[0];
                int currentCost = cityCost[1];
                //visited.add(city);
                List<int[]> edges = graph.getOrDefault(city, new ArrayList<int[]>());
                for (int[] edge: edges) {
                    int nextCity = edge[0];
                    //if (visited.contains(nextCity)) continue;
                    int newCost = currentCost + edge[1];
                    if (nextCity == dst) {
                        if (newCost < result || result == -1) result = newCost;
                        continue;
                    }
                    if (cost.containsKey(nextCity)) {
                        if (cost.get(nextCity) > newCost) {
                            cost.put(nextCity, newCost);
                            heap.offer(new int[] {nextCity, newCost});
                        }
                    } else {
                        cost.put(nextCity, newCost);
                        heap.offer(new int[] {nextCity, newCost});
                    }
                    //visited.add(nextCity);

//                     if (cost.containsKey(nextCity)) {
//                         if (newCost < cost.get(nextCity)) {
//                             cost.put(nextCity, newCost);
//                         }
//                     } else {
//                         cost.put(nextCity, newCost);
//                     }
                }
            }

            k--;
        }

        return result;
    }
}
