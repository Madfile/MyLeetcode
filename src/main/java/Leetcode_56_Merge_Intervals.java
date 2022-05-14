import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_56_Merge_Intervals {
    class Interval {
        public int start;
        public int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<Interval> output =  new ArrayList<Interval>();
        output.add(new Interval(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            addInterval(output, intervals[i]);
        }


        return toArray(output);
    }

    private int[][] toArray(List<Interval> intervals) {
        int[][] result = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); i++) {
            result[i][0] = intervals.get(i).start;
            result[i][1] = intervals.get(i).end;
        }

        return result;
    }

    private void addInterval(List<Interval> output, int[] interval) {
        Interval lastInterval = output.get(output.size() - 1);
        int start = interval[0];
        int end = interval[1];
        if (lastInterval.end < start) {
            output.add(new Interval(start, end));
        }

        if (lastInterval.end >= start && lastInterval.end < end) {
            lastInterval.end = end;
        }
    }
}
