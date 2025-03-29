public class SortColors75 {
    public void sortColors(int[] nums) {
        int low = 0;     // Pointer for the next position of 0
        int mid = 0;     // Pointer for the current element
        int high = nums.length - 1; // Pointer for the next position of 2

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors sorter = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sorter.sortColors(nums);
        
        // Print the sorted array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}


/*


Time Complexity
The time complexity is O(n), where n is the number of elements in the array, since we only pass through the array once.

Space Complexity
The space complexity is O(1) as we are sorting the array in place without using additional data structures.


  */
