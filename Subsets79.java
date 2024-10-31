import java.util.ArrayList;
import java.util.List;

public class Subsets79 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore further subsets
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); // Include the number in the current subset
            backtrack(result, current, nums, i + 1); // Recur for the next numbers
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Subsets subsetsGenerator = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsetsGenerator.subsets(nums);
        
        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
