/*
time complexity is O(n)O(n)O(n) and the space complexity is O(1)O(1)O(1)
  */
public class LengthOfLastWord58 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip any trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord solver = new LengthOfLastWord();
        String s = "Hello World ";
        int result = solver.lengthOfLastWord(s);
        System.out.println(result); // Output: 5
    }
}
