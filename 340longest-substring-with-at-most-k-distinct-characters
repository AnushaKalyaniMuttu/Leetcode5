import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            // Expand the window by including the right character
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            right++;

            // Shrink the window if the number of distinct characters exceeds k
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            // Calculate the length of the current valid window
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}
