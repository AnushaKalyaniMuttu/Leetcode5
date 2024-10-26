public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPos = mid; // Found target, continue to search left
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstPos;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPos = mid; // Found target, continue to search right
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastPos;
    }

    public static void main(String[] args) {
        FirstAndLastPosition solution = new FirstAndLastPosition();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]"); // Output: [3, 4]
    }
}

/*
Complexity Analysis
•	Time Complexity:
o	O(logN) for each binary search, so the total time complexity is O(logN).
•	Space Complexity:
o	O(1). We are using a constant amount of space for pointers and the result array.
Summary
This approach effectively finds the first and last position of a target element in a sorted array with:
•	Optimal Time Complexity: O(logN)
•	Optimal Space Complexity: O(1)


  */
