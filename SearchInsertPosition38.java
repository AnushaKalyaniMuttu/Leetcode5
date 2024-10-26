public class SearchInsertPosition38 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If not found, left is the insertion point
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = solution.searchInsert(nums, target);
        System.out.println("Insert Position: " + result); // Output: 2

        target = 2;
        result = solution.searchInsert(nums, target);
        System.out.println("Insert Position: " + result); // Output: 1

        target = 7;
        result = solution.searchInsert(nums, target);
        System.out.println("Insert Position: " + result); // Output: 4

        target = 0;
        result = solution.searchInsert(nums, target);
        System.out.println("Insert Position: " + result); // Output: 0
    }
}
