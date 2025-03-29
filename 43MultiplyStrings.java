public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0"; // Early return for zero cases
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2]; // Maximum possible length of the result

        // Reverse loop to multiply each digit
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // Multiply digits
                int sum = mul + result[i + j + 1]; // Add to the appropriate position in the result
                result[i + j + 1] = sum % 10; // Store the unit place
                result[i + j] += sum / 10; // Carry over to the next place
            }
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString(); // Handle case for all zeros
    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println("Product: " + solution.multiply(num1, num2)); // Output: 56088
    }
}
/*


Explanation of the Code
1.	Initialization:
o	Check for early return if either number is "0".
o	Create an array result to hold the intermediate products, with a maximum length of len1+len2.
2.	Digit Multiplication:
o	Use two nested loops to multiply each digit of num1 with each digit of num2.
o	Calculate the product and update the corresponding index in the result array.
o	Handle carries by updating the next index.
3.	Result Construction:
o	Use a StringBuilder to construct the final result string, skipping leading zeros.
o	Return "0" if no digits were added.
Time Complexity (TC) and Space Complexity (SC)
Time Complexity (TC)
•	The time complexity of this approach is:
O(m×n)
where mmm and nnn are the lengths of num1 and num2, respectively. This is because we have to multiply each digit of num1 with each digit of num2.
Space Complexity (SC)
•	The space complexity is:
O(m+n)
for the result array that can store the maximum possible number of digits.
Summary
•	Time Complexity: O(m×n)
•	Space Complexity: O(m+n)
*/
