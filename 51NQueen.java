import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), n, 0);
        return results;
    }

    private void backtrack(List<List<String>> results, List<String> board, int n, int row) {
        if (row == n) {
            results.add(new ArrayList<>(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == col ? 'Q' : '.');
                }
                board.add(sb.toString());
                backtrack(results, board, n, row + 1);
                board.remove(board.size() - 1);
            }
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int queenCol = board.get(i).indexOf('Q');
            if (queenCol == col || 
                queenCol - col == i - row || 
                queenCol - col == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4; // Change this value to test different board sizes
        List<List<String>> results = nQueens.solveNQueens(n);
        for (List<String> solution : results) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
