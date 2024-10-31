import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int required = charCountMap.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] result = {-1, 0, 0}; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (charCountMap.containsKey(c) && windowCounts.get(c).intValue() == charCountMap.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window
            while (l <= r && formed == required) {
                char leftChar = s.charAt(l);
                
                // Update the result if this window is smaller
                if (result[0] == -1 || r - l + 1 < result[0]) {
                    result[0] = r - l + 1;
                    result[1] = l;
                    result[2] = r;
                }

                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (charCountMap.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < charCountMap.get(leftChar).intValue()) {
                    formed--;
                }
                
                l++;
            }
            r++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t)); // Output: "BANC"
    }
}

/*
Time Complexity
The time complexity is O(n + m), where n is the length of string s and m is the length of string t.

Space Complexity
The space complexity is O(m) for the character count map, where m is the number of unique characters in t

  */
