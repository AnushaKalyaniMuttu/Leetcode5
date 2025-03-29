import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            int j = i;
            int lineLength = 0;

            // Determine how many words can fit in the current line
            while (j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            // Prepare the line with words from index i to j-1
            StringBuilder line = new StringBuilder();
            int numWords = j - i;
            int spacesToAdd = maxWidth - lineLength;

            // If it's the last line or only one word, left justify
            if (numWords == 1 || j >= n) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" "); // Add single space between words
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" "); // Fill remaining spaces
                }
            } else {
                int spaceBetweenWords = spacesToAdd / (numWords - 1);
                int extraSpaces = spacesToAdd % (numWords - 1);

                // Add words and spaces
                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    // Add spaces if it's not the last word in the line
                    if (k < j - 1) {
                        for (int s = 0; s < spaceBetweenWords; s++) {
                            line.append(" ");
                        }
                        // If there are extra spaces, add one more to the leftmost gap
                        if (extraSpaces > 0) {
                            line.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j; // Move to the next set of words
        }

        return result;
    }
}


/*
Time Complexity: O(n)
Space Complexity: O(n)
  */
