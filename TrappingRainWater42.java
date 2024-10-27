public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left]; // Calculate trapped water
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right]; // Calculate trapped water
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Water trapped: " + solution.trap(height));
    }
}


/*
Explanation of the Code
1.	Initialization: We set two pointers (left and right) to the start and end of the array, and initialize leftMax and rightMax to keep track of the highest bars encountered from both sides. waterTrapped stores the total amount of trapped water.
2.	Two-Pointer Approach:
o	While the left pointer is less than the right pointer, compare the heights at these two pointers.
o	If the height at the left pointer is less than the height at the right pointer:
	Update leftMax with the maximum height encountered so far from the left.
	Calculate the trapped water at the current left position as leftMax - height[left].
	Move the left pointer to the right.
o	Otherwise, do the same for the right pointer.
3.	Return Result: The total trapped water is returned after the loop.
Time Complexity (TC) and Space Complexity (SC)
Time Complexity (TC)
•	The algorithm makes a single pass through the array, so the time complexity is:
O(n)
where n is the number of elements in the height array.
Space Complexity (SC)
•	The space complexity is:
O(1)
since we are using a constant amount of extra space (for the pointers and max height variables) and not using any additional data structures.
Summary
•	Time Complexity: O(n)
•	Space Complexity: O(1)


  */
