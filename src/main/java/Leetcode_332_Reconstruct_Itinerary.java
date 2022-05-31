import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_332_Reconstruct_Itinerary {
    class Solution {


        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        LinkedList<String> result = new LinkedList<String>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                if (!map.containsKey(ticket.get(0))) {
                    PriorityQueue<String> q = new PriorityQueue<String>();
                    map.put(ticket.get(0), q);
                }
                map.get(ticket.get(0)).offer(ticket.get(1));
            }

            dfs("JFK");
            return result;
        }

        public void dfs(String s) {
            PriorityQueue<String> q = map.get(s);

            while (q != null && !q.isEmpty()) {
                dfs(q.poll());
            }

            result.addFirst(s);
        }

        // public List<String> findItinerary(List<List<String>> tickets) {
//         int num = tickets.size() + 1;
//         List<List<String>> results = new ArrayList<>();

//         //build graph
//         Map<String, List<String>> graph = new HashMap<>();
//         for (List<String> ticket: tickets) {
//             List<String> dsts = graph.getOrDefault(ticket.get(0), new ArrayList<>());
//             dsts.add(ticket.get(1));
//             graph.put(ticket.get(0), dsts);
//         }

//         //DFS
//         Set<String[]> used = new HashSet<>();
//         dfs("JFK", results, new ArrayList<String>(), graph, num, used);

//         //return smallest lexical order result
//         return results.get(0);
//     }

//     private boolean dfs(String city, List<List<String>> results, List<String> current, Map<String, List<String>> graph, int num, Set<String[]> used) {
//         //System.out.println(current);
//         List<String> nextCities = graph.getOrDefault(city, new ArrayList<String>());
//         if (nextCities.size() == 0) {
//             current.add(city);
//             if (current.size() != num) {
//                  current.remove(city);
//                 return false;
//             } else {
//                 results.add(current);
//                 return true;
//             }
//         }

//         for(String nextCity: nextCities) {
//             String[] ticket = new String[]{city, nextCity};
//             System.out.println("used:" + used);
//             if (used.contains(ticket)) continue;
//             current.add(city);
//             used.add(ticket);
//             if (!dfs(nextCity, results, current, graph, num, used)) {
//                 current.remove(city);
//                 used.remove(ticket);
//             }
//         }

//         return true;
//     }
    }
}
