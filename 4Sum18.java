import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;  // Start of the third number
                int right = n - 1; // Start of the fourth number

                while (left < right) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right]; // Use long to avoid overflow
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Need a larger sum
                    } else {
                        right--; // Need a smaller sum
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int target = -294967296;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result); // Should output []
    }
}


/*

Time Complexity: 
𝑂(𝑁3)

Space Complexity O(K)
*/
