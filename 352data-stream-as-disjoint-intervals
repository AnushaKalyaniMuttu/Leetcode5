import java.util.TreeMap;

class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if (intervals.containsKey(value)) {
            return; // Value already exists
        }

        Integer lowerKey = intervals.floorKey(value);
        Integer higherKey = intervals.ceilingKey(value);

        boolean mergeLeft = lowerKey != null && intervals.get(lowerKey) + 1 >= value;
        boolean mergeRight = higherKey != null && higherKey - 1 <= value;

        if (mergeLeft && mergeRight) {
            // Merge both intervals
            int newStart = lowerKey;
            int newEnd = intervals.get(higherKey);
            intervals.put(newStart, newEnd);
            intervals.remove(higherKey);
        } else if (mergeLeft) {
            // Merge with the left interval
            intervals.put(lowerKey, Math.max(intervals.get(lowerKey), value));
        } else if (mergeRight) {
            // Merge with the right interval
            int newEnd = intervals.get(higherKey);
            intervals.remove(higherKey);
            intervals.put(value, newEnd);
        } else {
            // Create a new interval
            intervals.put(value, value);
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        int index = 0;

        for (var entry : intervals.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        return result;
    }
}
