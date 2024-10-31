import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        // If the current combination is of the desired size, add it to the result
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore further combinations
        for (int i = start; i <= n; i++) {
            current.add(i); // Choose the current number
            backtrack(result, current, n, k, i + 1); // Recurse with the next number
            current.remove(current.size() - 1); // Backtrack to explore next combination
        }
    }

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        int n = 4, k = 2;
        List<List<Integer>> result = comb.combine(n, k);
        
        // Print the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
/*
Time Complexity
The time complexity is O(C(n, k)), where C(n, k) is the number of combinations. This is due to the fact that each combination takes linear time to create.

Space Complexity
The space complexity is O(k) for the current combination, and O(C(n, k)) for the result list.
  */
