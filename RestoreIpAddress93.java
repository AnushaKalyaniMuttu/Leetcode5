import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result, 0);
        return result;
    }

    private void backtrack(String s, int start, StringBuilder current, List<String> result, int segmentCount) {
        // If we have 4 segments and we've used the entire string, we have a valid IP address
        if (segmentCount == 4) {
            if (start == s.length()) {
                result.add(current.toString());
            }
            return;
        }

        // Try to take 1, 2, or 3 digits for the current segment
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break; // Not enough characters left
            String segment = s.substring(start, start + len);
            // Validate the segment
            if (isValidSegment(segment)) {
                int currentLength = current.length();
                // Add segment to current IP
                if (segmentCount > 0) {
                    current.append("."); // Add a dot before the segment if it's not the first segment
                }
                current.append(segment);
                // Backtrack for the next segment
                backtrack(s, start + len, current, result, segmentCount + 1);
                // Remove the last segment for backtracking
                current.setLength(currentLength);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() == 0 || segment.length() > 3) return false;
        if (segment.charAt(0) == '0' && segment.length() > 1) return false; // No leading zeros
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255; // Must be in range
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "25525511135";
        List<String> validIPs = sol.restoreIpAddresses(input);
        for (String ip : validIPs) {
            System.out.println(ip);
        }
    }
}
/*
In analyzing the time complexity (TC) and space complexity (SC) of the solution for restoring IP addresses, we can break it down as follows:
Time Complexity (TC)
1.	Backtracking Tree: The algorithm uses backtracking to explore all possible combinations of segments. Each segment can take 1 to 3 digits, and at each level of recursion, we are exploring up to 3 branches (1-digit, 2-digit, or 3-digit segments).
2.	Total Combinations: In the worst case, the string has 12 digits (e.g., "255255255255"). The depth of the recursion will be at most 4 (since we need 4 segments). For each position in the string, we can try up to 3 lengths, leading to a branching factor of 3.
3.	Complexity: The backtracking effectively generates combinations, which can lead to an exponential number of possibilities. Thus, the time complexity can be considered as:
O(34)(for depth 4) 
However, since we only consider valid segment lengths, this is often simplified in practice to:
O(1)(constant number of possible segments)O(1) 
as the string length is limited to 12.
Space Complexity (SC)
1.	Output Storage: The result list will store valid IP addresses. In the worst case, there can be a limited number of valid IP addresses, but the maximum number of valid combinations is constrained by the segments.
2.	Recursive Call Stack: The maximum depth of the recursion stack will be 4 (for 4 segments).
3.	Overall Space Complexity: The total space used can be expressed as:
O(N)(where N is the number of valid IPs stored)O(N) \quad \text{(where N is the number of valid IPs stored)}O(N)(where N is the number of valid IPs stored)
plus the depth of the recursion stack, which is:
O(4)=O(1)(constant space for stack)O(4) = O(1) 
Thus, the overall space complexity can be considered:
O(N)
Summary
•	Time Complexity: O(3^4) or simplified to O(1) for practical purposes due to limited input size.
•	Space Complexity: O(N), where N is the number of valid IP addresses stored in the result list.

*/
