public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the width and the height for the current container
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            // Calculate the area and update maxArea if needed
            maxArea = Math.max(maxArea, width * currentHeight);

            // Move the pointer pointing to the shorter line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height)); // Output: 49
    }
}
