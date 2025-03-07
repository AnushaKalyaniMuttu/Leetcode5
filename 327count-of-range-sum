public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return mergeSort(sums, 0, sums.length - 1, lower, upper);
    }

    private int mergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        
        int mid = (start + end) / 2;
        int count = mergeSort(sums, start, mid, lower, upper) + mergeSort(sums, mid + 1, end, lower, upper);
        
        int j = mid + 1, k = mid + 1, t = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && sums[j] - sums[i] < lower) j++;
            while (k <= end && sums[k] - sums[i] <= upper) k++;
            while (t <= end && sums[t] < sums[i]) t++;
            count += k - j;
        }

        long[] temp = new long[end - start + 1];
        int left = start, right = mid + 1, idx = 0;
        while (left <= mid && right <= end) {
            if (sums[left] <= sums[right]) {
                temp[idx++] = sums[left++];
            } else {
                temp[idx++] = sums[right++];
            }
        }
        while (left <= mid) temp[idx++] = sums[left++];
        while (right <= end) temp[idx++] = sums[right++];
        System.arraycopy(temp, 0, sums, start, temp.length);

        return count;
    }
}
