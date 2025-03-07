import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length != 2) {
            return 0;
        }

        // Step 1: Sort the envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order of height
            }
            return a[0] - b[0]; // Ascending order of width
        });

        // Step 2: Extract heights and apply LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}
