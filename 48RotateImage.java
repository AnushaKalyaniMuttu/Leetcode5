public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements at (i,j) and (j,i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateImage rotator = new RotateImage();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        rotator.rotate(matrix);

        // Print the rotated matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

/*
Explanation of the Code
Transpose the Matrix:

The outer loop iterates through each row.
The inner loop starts from the diagonal to avoid swapping the same elements twice.
We swap the elements at positions (i, j) and (j, i).
Reverse Each Row:

We reverse each row using a helper method reverseRow.
This method uses two pointers to swap elements from the beginning and the end of the row until they meet in the middle.
Complexity Analysis
Time Complexity:

The transposition step takes O(n^2) time because we traverse the n × n matrix.
The reversal of each row also takes O(n) for each of the n rows, resulting in O(n^2) in total.
Thus, the overall time complexity is O(n^2).
Space Complexity:

The algorithm performs the rotation in place, requiring only O(1) additional space for the swapping operation.
The overall space complexity is O(1)


*/
