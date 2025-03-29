import java.util.*;

class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s; // No rearrangement needed for k <= 1
        }

        // Step 1: Count frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Step 2: Add characters to a max heap based on their frequencies
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCount.get(b) - charCount.get(a));
        maxHeap.addAll(charCount.keySet());

        // Step 3: Build the rearranged string
        StringBuilder result = new StringBuilder();
        Queue<Character> waitQueue = new LinkedList<>(); // To enforce the k-distance constraint

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); // Most frequent character
            result.append(current);
            charCount.put(current, charCount.get(current) - 1);

            // Add the current character to the wait queue
            waitQueue.offer(current);

            // If the wait queue exceeds size k, reinsert the character if it still has a remaining count
            if (waitQueue.size() >= k) {
                char front = waitQueue.poll();
                if (charCount.get(front) > 0) {
                    maxHeap.offer(front);
                }
            }
        }

        // If the result length doesn't match the input string length, return an empty string
        return result.length() == s.length() ? result.toString() : "";
    }
}
