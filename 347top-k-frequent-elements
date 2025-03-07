import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Priority Queue (Min-Heap) to keep top K frequent elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2)
        );

        for (int num : frequencyMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }

        // Build the result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }
}
