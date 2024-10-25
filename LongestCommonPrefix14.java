public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume the first string is the common prefix initially
        String prefix = strs[0];

        for (int i = 0; i < prefix.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                // Check if the current index is out of bounds or characters don't match
                if (i >= strs[j].length() || strs[j].charAt(i) != prefix.charAt(i)) {
                    // Update the prefix to the common prefix found so far
                    return prefix.substring(0, i);
                }
            }
        }

        return prefix; // All characters of the first string are common
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs)); // Output: "fl"
    }
}

//Time Complexity O(n⋅m)
//Space Complexity O(1)
