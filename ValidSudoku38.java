import java.util.HashSet;

public class ValidSudoku38 {

    public boolean isValidSudoku(char[][] board) {
        // Sets to keep track of seen numbers
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Create unique keys for row, column, and sub-box
                    String rowKey = "row " + i + " " + num;
                    String colKey = "col " + j + " " + num;
                    String boxKey = "box " + (i / 3) + " " + (j / 3) + " " + num;

                    // Check if the number has already been seen
                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false; // Invalid
                    }
                }
            }
        }
        return true; // Valid
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        boolean result = solution.isValidSudoku(board);
        System.out.println("Is valid Sudoku: " + result); // Output: true
    }
}


/*



Complexity Analysis
•	Time Complexity:
o	O(1) (specifically O(81), since we always iterate through a fixed number of cells (9x9).
•	Space Complexity:
o	O(1) as the maximum number of entries in the hash set is constant (at most 27 for 9 rows, 9 columns, and 9 boxes).
Summary
This approach efficiently checks the validity of a Sudoku board using:
•	Optimal Time Complexity: O(1)
•	Optimal Space Complexity: O(1)


  */
