public class UniquePathsTwo62 {
    public int uniquePaths(int m, int n) {
        int totalMoves = m + n - 2;
        int downs = m - 1; // or rights = n - 1
        long result = 1;

        // Calculate combination C(totalMoves, downs)
        for (int i = 1; i <= downs; i++) {
            result = result * (totalMoves - (downs - i)) / i;
        }

        return (int) result;
    }
}
/*


Complexity Analysis (Combinatorial):
•	Time Complexity: O(min(m,n)) because you only iterate over the smaller of the two dimensions.
•	Space Complexity: O(1) since you only use a few variables.

*/
