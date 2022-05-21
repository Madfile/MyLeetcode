import java.util.*;
import java.util.stream.Collectors;

public class Leetcode_310_Minimum_Height_Trees {
    // My solution works but will exceed time limit
// class Solution {
//     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//         //construct graph
//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         for (int[] edge: edges) {
//             List<Integer> edgesOne = graph.getOrDefault(edge[0], new ArrayList<>());
//             edgesOne.add(edge[1]);
//             graph.put(edge[0], edgesOne);

//             List<Integer> edgesTwo = graph.getOrDefault(edge[1], new ArrayList<>());
//             edgesTwo.add(edge[0]);
//             graph.put(edge[1], edgesTwo);
//         }

//         //bfs
//         Map<Integer, Integer> heightMap = new HashMap<>();
//         int minimumHeight = Integer.MAX_VALUE;
//         for (int i = 0; i < n; i++) {
//             Queue<Integer> queue = new LinkedList<>();
//             queue.add(i);
//             int height = 0;
//             Set<Integer> visited = new HashSet<>();

//             while(!queue.isEmpty()) {
//                 int size = queue.size();
//                 for (int j = 0; j < size; j++) {
//                     int node = queue.poll();
//                     visited.add(node);
//                     //consider orphan nodes
//                     if (graph.containsKey(node)) {
//                         for (int adjacent: graph.get(node)) {
//                             if (!visited.contains(adjacent))  queue.offer(adjacent);
//                         }
//                     }
//                     //if (i == 1) System.out.println("current: " + node + ": " + queue);
//                 }

//                 height++;
//                 if (height > minimumHeight) break;
//                 //if (i == 1) System.out.println("height: " + height);
//             }

//             if (!heightMap.containsKey(i)) {
//                 heightMap.put(i, height);
//             } else if (heightMap.get(i) > height) {
//                 heightMap.put(i, height);
//             }

//             if (height < minimumHeight) minimumHeight = height;

//             //System.out.println(i + ": " + height);
//         }

//         final int finalHeight = minimumHeight;

//         List<Integer> result = heightMap.keySet().stream().filter(node -> heightMap.get(node) == finalHeight).collect(Collectors.toList());

//         return result;
//     }
// }

    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            if(n < 2){
                for(int i = 0; i < n; i++){
                    res.add(i);
                }
                return res;
            }


            HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
            int[] degree = new int[n];

            for(int i = 0; i < n; i++){
                hashMap.put(i, new ArrayList<>());
            }

            for(int i = 0; i < edges.length; i++){
                int oneEnd = edges[i][0];
                int anotherEnd = edges[i][1];
                hashMap.get(oneEnd).add(anotherEnd);
                hashMap.get(anotherEnd).add(oneEnd);
                degree[oneEnd]++;
                degree[anotherEnd]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < degree.length; i++){
                if(degree[i] == 1){
                    queue.offer(i);
                    res.add(i);
                }
            }

            int qLength = queue.size();

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int t : hashMap.get(cur)){
                    if(--degree[t] == 1){
                        queue.offer(t);
                    }
                }
                qLength--;
                if(qLength == 0){
                    if(queue.size() == 0){
                        break;
                    }
                    res = queue.stream().collect(Collectors.toList());
                    qLength = queue.size();
                }
            }

            return res;

        }
    }
}
