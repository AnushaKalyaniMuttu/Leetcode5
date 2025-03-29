public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) {
            return s; // No conversion needed
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0) {
                goingDown = true; // Start going down
            } else if (currentRow == numRows - 1) {
                goingDown = false; // Start going up
            }
            currentRow += goingDown ? 1 : -1; // Move to the next row
        }

        // Concatenate all rows into a single string
        StringBuilder zigzag = new StringBuilder();
        for (StringBuilder row : rows) {
            zigzag.append(row);
        }

        return zigzag.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(solution.convert(input, numRows)); // Output: "PAHNAPLSIIGYIR"
    }
}


//time complexity O(n)
//Space complexity O(n)
