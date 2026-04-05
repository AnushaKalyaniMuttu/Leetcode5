class Solution {
    private int count = 0;
    private int maxOR = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) maxOR |= num; // maximum OR possible
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOR) count++;
            return;
        }
        // Include nums[index]
        dfs(nums, index + 1, currentOr | nums[index]);
        // Exclude nums[index]
        dfs(nums, index + 1, currentOr);
    }
}
