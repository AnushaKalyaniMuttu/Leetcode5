public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;

        int first = 1;
        int second = 1;
        int ways = 0;

        for (int i = 2; i <= n; i++) {
            ways = first + second;
            first = second;
            second = ways;
        }

        return ways;
    }
}


/*
Both approaches have a time complexity of O(n), and the space complexity is O(n) for the first approach and O(1) for the optimized version.

*/
