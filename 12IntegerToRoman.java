public class IntegerToRoman12 {
    public String intToRoman(int num) {
        // Define the Roman numeral symbols and their corresponding values
        String[] romanSymbols = {
            "M", "CM", "D", "CD", "C",
            "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"
        };
        int[] values = {
            1000, 900, 500, 400, 100,
            90, 50, 40, 10,
            9, 5, 4, 1
        };

        StringBuilder roman = new StringBuilder();

        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanSymbols[i]); // Append the corresponding symbol
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 1994;
        System.out.println(solution.intToRoman(number)); // Output: "MCMXCIV"
    }
}

//time Complexity O(1)
//Space Complexity O(1)
