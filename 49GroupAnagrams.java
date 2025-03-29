import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Count the frequency of each character
            int[] charCount = new int[26]; // Assuming only lowercase English letters
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Convert the character count to a string key
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#'); // Use '#' as a separator
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();

            // Add the original string to the anagram group
            anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(strs);

        // Print the grouped anagrams
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
/*
Explanation of the Code
Character Frequency Array:

We create an integer array of size 26 to count the frequency of each character for each string.
Creating a Unique Key:

We construct a string key that represents the character frequencies. Each frequency is separated by a '#' to differentiate between counts.
Storing Anagrams:

We use a HashMap where the key is the character frequency string and the value is a list of strings (anagrams).
The computeIfAbsent method adds the string to the corresponding list if the key doesn't exist.
Returning Results:

Finally, we return the values of the HashMap as a list of lists.
Complexity Analysis
Time Complexity:

The algorithm processes each string in the input array once, with each string being processed in O(k) time, where k is the length of the string. Thus, for n strings, the total time complexity is O(n * k).
Space Complexity:

The space complexity is O(n * k) in the worst case, where n is the number of strings and k is the length of the longest string, due to storing the grouped anagrams in the list.


 */ 
