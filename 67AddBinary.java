public class AddBinary67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert char to int
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert char to int
                j--;
            }

            result.append(sum % 2); // Append the result bit (0 or 1)
            carry = sum / 2; // Update the carry
        }

        // The result is in reverse order, so reverse it
        return result.reverse().toString();
    }
}

/*
Time and Space Complexity
•	Time Complexity: O(max(n, m)), where n and m are the lengths of the two input strings.
•	Space Complexity: O(max(n, m)), for the resulting binary string.
*/
