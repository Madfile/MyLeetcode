import java.util.*;
import java.util.stream.Collectors;

public class Leetcode_1338_Reduce_Array_Size_to_The_Half {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        list.sort((o1, o2) -> {
            if (o1.getValue() == o2.getValue()) return 0;
            else return o1.getValue() > o2.getValue() ? -1 : 1;
        });

        int res = 0;
        int removed = 0;
        for (Map.Entry<Integer, Integer> entry: list) {
            removed += entry.getValue();
            res++;
            if (removed >= arr.length/2) break;
        }

        return res;
    }
}
