public class FindFirstOccurrence {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = computeLPSArray(needle);
        int i = 0; // Pointer for haystack
        int j = 0; // Pointer for needle

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                return i - j; // Found the needle, return the starting index
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip unnecessary comparisons
                } else {
                    i++;
                }
            }
        }

        return -1; // Needle not found
    }

    private int[] computeLPSArray(String needle) {
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1; // Current index in needle
        int[] lps = new int[needle.length()];
        lps[0] = 0; // lps[0] is always 0

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Backtrack using the LPS array
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        FindFirstOccurrence solution = new FindFirstOccurrence();
        String haystack = "hello";
        String needle = "ll";
        int index = solution.strStr(haystack, needle);
        System.out.println("Index: " + index); // Output: 2
    }
}
/*
Complexity Analysis (KMP Algorithm)
•	Time Complexity:
o	O(N+M), where N is the length of the haystack and MMM is the length of the needle.
•	Space Complexity:
o	O(M)O(M)O(M) for the LPS array.
Summary
•	Using Built-in Method: Simple and effective for most cases with average time complexity O(N).
•	Using KMP Algorithm: More efficient for larger inputs with a guaranteed time complexity of O(N+M).


  */
