public class SearchInRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if we've found the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine the sorted half
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target in the left half
                } else {
                    left = mid + 1; // Target in the right half
                }
            } else { // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target in the right half
                } else {
                    right = mid - 1; // Target in the left half
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of target: " + result); // Output: 4
    }
}
