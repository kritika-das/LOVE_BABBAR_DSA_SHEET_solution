import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class mergeinterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
              
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] mergedIntervals = solution.merge(intervals);

        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
