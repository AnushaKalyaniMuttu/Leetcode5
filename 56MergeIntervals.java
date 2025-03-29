import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals by the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // If there is an overlap, merge the intervals
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // No overlap, add the current interval to the list
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        
        // Add the last interval
        merged.add(currentInterval);
        
        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mi.merge(intervals);
        
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}


/*
Time Complexity: O(nlogn)

Space Complexity: O(n)
  */
