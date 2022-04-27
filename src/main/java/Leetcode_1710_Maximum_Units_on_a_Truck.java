import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_1710_Maximum_Units_on_a_Truck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int capacity = 0;

        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int[] boxes: boxTypes) {
            int num = boxes[0];
            int units = boxes[1];

            while (truckSize > 0 && num > 0) {
                truckSize--;
                num--;
                capacity += units;
            }
        }


        return capacity;
    }
}
