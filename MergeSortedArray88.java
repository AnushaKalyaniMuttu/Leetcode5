public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Last index of the merged array
        int i = m + n - 1;
        // Last index of nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;

        // Merge in reverse order
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }

        // If there are remaining elements in nums2
        while (p2 >= 0) {
            nums1[i] = nums2[p2];
            p2--;
            i--;
        }
        // No need to copy the remaining elements of nums1, as they are already in place
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);
        
        // Print merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: 1 2 2 3 5 6
    }
}
/*
Complexity
Time Complexity: O(m + n), where m and n are the lengths of the two arrays.
Space Complexity: O(1), since we are merging in place.

  */
