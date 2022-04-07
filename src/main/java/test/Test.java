package src.main.java.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "one");
        String one = map.remove("1");
        System.out.println(one);

        if (map.get("2") == null) {
            System.out.println("empty");
        }

        ArrayList<String> list = new ArrayList(Arrays.asList("a", "b", "c"));

        int[] nums = new int[] {1,2,3,6,4,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
