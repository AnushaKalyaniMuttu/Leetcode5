public class Solution {
    public int minPatches(int[] nums, int n) {
        long covered = 0;
        int patches = 0, i = 0;
        
        while (covered < n) {
            if (i < nums.length && nums[i] <= covered + 1) {
                covered += nums[i++];
            } else {
                covered += covered + 1;
                patches++;
            }
        }
        
        return patches;
    }
}
