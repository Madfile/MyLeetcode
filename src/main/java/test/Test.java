package src.main.java.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Queue<String> queue = new LinkedList<String>();
////        Arrays.sort(new int[]{1,2,3,4});
//
//        queue.add("1");
//        queue.add("2");
//        queue.add("3");
//        queue.add("4");
//        queue.add("5");
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("1", "one");
//        String one = map.remove("1");
//        System.out.println(one);
//
//        if (map.get("2") == null) {
//            System.out.println("empty");
//        }
//
//        ArrayList<String> list = new ArrayList(Arrays.asList("a", "b", "c"));
//        Collections.reverse(list);
//        Collections.sort(list);
//
//        int[] nums = new int[] {1,2,3,6,4,5};
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//
//        System.out.println(5 / 2);
//
//        HashMap<String, ArrayList<String>> graph = new HashMap<>();
//        graph.computeIfAbsent("key1", k -> new ArrayList<String>()).add("value1");
//
//        System.out.println((-1) * (-1) == 1);
//        List<Integer> list = new ArrayList<>();
//        list.add(0, -1);
//        //can only set existed item
//        list.set(0, 1);
//        list.add(0, 2);
//        System.out.println(list);
//        Map<String, String> testMap = new HashMap<>();
//        testMap.getOrDefault("1", "1");
//        testMap.computeIfAbsent("1", v -> new String("5"));
//
//        System.out.println("a compare to b:" + "a".compareTo("b"));
//
//        int minimumHeight = 3;
//        Map<Integer, Integer> testGraph = new HashMap<>();
//        List<Integer> result = testGraph.keySet().stream().filter(node -> testGraph.get(node) == minimumHeight).collect(Collectors.toList());
//
//        Set<Integer> visited = new HashSet<>();
//        visited.add(1);
//
//        int i = 10;
//        int j = 3;
//
//        Integer[] test2 = new Integer[]{1,2,3};
//        Arrays.sort(test2, Collections.reverseOrder());
////        Arrays.sort(test, new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o2 - o1;
////            }
////        });
//        int[][] stockPrices = new int[][]{{1,2},{2,4},{4,3},{3,2}};
//        Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);
//
//        String a  = "123455";
//        //char c = '1';
//        for (char c: a.toCharArray()) {
//            System.out.println(c);
//        }
//
//        List<Integer[]> list = new ArrayList<>();
//        //int[] intArray = new int[]{1};
//        List<Integer> item = new ArrayList<>();
//        item.add(1);
//        list.add((Integer[])item.toArray());
//
//        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//
//        String binary = "11111111111111111111101100001111";
//        long decimal = Integer.parseInt(binary, 2);
//        System.out.println(decimal);
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.insert(sb.length() - 1, 'b');

        //System.out.println(longestSubsequence("00101001", 1));
        int[]a = new int[]{1,5,5,6};
        int index = Arrays.binarySearch(a, 0, 4, 5);

        System.out.println(index);
    }
    public static int longestSubsequence(String s, int k) {
        StringBuilder sub = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == '0') {
                sub.append("0");
            }
        }

        StringBuilder tmp =new StringBuilder(s);
        tmp.reverse();
        s =  tmp.toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sub.insert(sub.length() - i, '1');
                if (Integer.parseInt(sub.toString(), 2) > k) {
                    return sub.length() - 1;
                }
            }
        }

        return sub.length();
    }
}


