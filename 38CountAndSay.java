public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String result = "1"; // Starting point for the sequence
        for (int i = 1; i < n; i++) {
            result = getNextTerm(result);
        }
        return result;
    }

    private String getNextTerm(String term) {
        StringBuilder nextTerm = new StringBuilder();
        int count = 1;

        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == term.charAt(i - 1)) {
                count++;
            } else {
                nextTerm.append(count).append(term.charAt(i - 1));
                count = 1; // Reset count for the new digit
            }
        }

        // Append the last counted digit
        nextTerm.append(count).append(term.charAt(term.length() - 1));

        return nextTerm.toString();
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        int n = 5; // Example input
        System.out.println("The " + n + "th term of the Count and Say sequence is: " + cs.countAndSay(n));
    }
}



/*

Summary Summary
•	Time Complexity: O(2^n)
•	Space Complexity: O(2^n)



*/
