class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0; // Decide the direction of filling

        while (i <= j) {
            int left = calculate(nums[i], a, b, c);
            int right = calculate(nums[j], a, b, c);

            if (a >= 0) { // If parabola opens upwards
                if (left > right) {
                    result[index--] = left;
                    i++;
                } else {
                    result[index--] = right;
                    j--;
                }
            } else { // If parabola opens downwards
                if (left < right) {
                    result[index++] = left;
                    i++;
                } else {
                    result[index++] = right;
                    j--;
                }
            }
        }

        return result;
    }

    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
