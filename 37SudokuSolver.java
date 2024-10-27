public class SudokuSolver {
    public static final int SIZE = 9; // For 9x9 Sudoku

    public boolean solveSudoku(char[][] board) {
        int[] emptySpot = findEmptyLocation(board);
        if (emptySpot == null) {
            return true; // Puzzle solved
        }

        int row = emptySpot[0];
        int col = emptySpot[1];

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num; // Place number

                if (solveSudoku(board)) {
                    return true; // Continue solving
                }

                board[row][col] = '.'; // Backtrack
            }
        }

        return false; // Trigger backtracking
    }

    private int[] findEmptyLocation(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j}; // Return row and column
                }
            }
        }
        return null; // No empty spots
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        // Check row and column
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true; // Valid number
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
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

        if (solver.solveSudoku(board)) {
            System.out.println("Sudoku solved!");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static void printBoard(char[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.print("\n");
        }
    }
}


/*
Summary
•	Time Complexity: O(981) in the worst case, but usually much faster in practice.
•	Space ComplexityO(N2), where N is the size of the Sudoku board (9 for standard Sudoku).

  */
