import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();

        // Add all intervals before the newInterval
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval); // Add the merged newInterval

        // Add the remaining intervals
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = ii.insert(intervals, newInterval);
        
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}


/*
Time Complexity:
•	Sorting: O(nlog⁡n)O(n \log n)O(nlogn) if the list is not sorted.
•	Insertion and Merging: O(n)O(n)O(n), where nnn is the number of existing intervals.
Space Complexity:
•	Output Storage: O(n)O(n)O(n) in the worst case if all intervals need to be stored.


  */
