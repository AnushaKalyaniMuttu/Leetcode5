import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalNumbers = 1 << n; // This is 2^n
        
        for (int i = 0; i < totalNumbers; i++) {
            // Calculate Gray code for i
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        List<Integer> grayCodeSequence = solution.grayCode(n);
        
        // Print the result
        System.out.println(grayCodeSequence); // Output: [0, 1, 3, 2]
    }
}

/*

Complexity
Time Complexity: O(2^n), since we generate 2^n numbers.
Space Complexity: O(2^n), as we store the results in a list.
*/
