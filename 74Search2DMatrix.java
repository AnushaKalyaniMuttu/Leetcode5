public class Search2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Found the target
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        Search2DMatrix sdm = new Search2DMatrix();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(sdm.searchMatrix(matrix, target)); // Output: true
    }
}
/*
Time Complexity
The time complexity is O(m + n), where m is the number of rows and n is the number of columns, since each step either decreases the column index or increases the row index.

Space Complexity
The space complexity is O(1) as we are using a constant amount of extra space.
  */
