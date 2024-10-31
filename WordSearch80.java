public class WordSearch80 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true; // Word found
                }
            }
        }
        return false; // Word not found
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If the entire word is found
        if (index == word.length()) return true;

        // Check bounds and if the character matches
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '#'; // Use a marker to indicate visited

        // Explore all possible directions
        boolean found = dfs(board, word, i + 1, j, index + 1) || // Down
                        dfs(board, word, i - 1, j, index + 1) || // Up
                        dfs(board, word, i, j + 1, index + 1) || // Right
                        dfs(board, word, i, j - 1, index + 1);   // Left

        // Unmark the cell
        board[i][j] = temp; // Restore the original value
        return found;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word)); // Output: true
    }
}

/*
Time Complexity
The time complexity is O(m * n * 4^L), where m and n are the dimensions of the board and L is the length of the word. In the worst case, every cell could lead to 4 recursive calls.

Space Complexity
The space complexity is O(L) due to the recursion stack, where L is the length of the word.
  */
