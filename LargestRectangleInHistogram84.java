import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length) {
            // Push the index of the current bar onto the stack if it's higher than the bar at the index on the top of the stack
            if (stack.isEmpty() || heights[index] >= heights[stack.peek()]) {
                stack.push(index++);
            } else {
                // Pop the top index from the stack
                int top = stack.pop();
                // Calculate the area with heights[top] as the smallest (limiting) height
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }

        // Process any remaining bars in the stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea; // Return the maximum area found
    }
}
/*
Time Complexity
The algorithm runs in O(n) time, where n is the number of bars in the histogram, because each index is pushed and popped from the stack at most once. The space complexity is O(n) for the stack in the worst case.
  */
