class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    // Constructor to initialize the game board
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int toAdd = (player == 1) ? 1 : -1; // Use 1 for player 1 and -1 for player 2

        rows[row] += toAdd;       // Update the row
        cols[col] += toAdd;       // Update the column

        // Update the diagonal
        if (row == col) {
            diagonal += toAdd;
        }

        // Update the anti-diagonal
        if (row + col == rows.length - 1) {
            antiDiagonal += toAdd;
        }

        int n = rows.length;

        // Check if any condition for winning is satisfied
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
            Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
            return player;
        }

        return 0; // No winner yet
    }
}
