import java.util.*;

class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }

        Set<String> pointSet = new HashSet<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;

        // Add points to the set and track the min and max x-coordinates
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            pointSet.add(point[0] + "," + point[1]);
        }

        // Calculate the line of reflection
        double reflectionLine = (minX + maxX) / 2.0;

        // Verify that each point has its mirrored counterpart
        for (int[] point : points) {
            int reflectedX = (int) (2 * reflectionLine - point[0]);
            String mirroredPoint = reflectedX + "," + point[1];
            if (!pointSet.contains(mirroredPoint)) {
                return false;
            }
        }

        return true;
    }
}
