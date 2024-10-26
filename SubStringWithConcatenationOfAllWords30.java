class SubStringWithConcatenationOfAllWords30 {
        public List<Integer> findSubstring(String s, String[] words) {
           List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        // Create a frequency map for the words
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        // Iterate through possible starting indices
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            HashMap<String, Integer> seenWords = new HashMap<>();

            while (right + wordLength <= s.length()) {
                // Get the next word from the right end
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // Only process if the word is part of the word list
                if (wordFrequency.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have too many of this word, move the left pointer
                    while (seenWords.get(word) > wordFrequency.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // If the count matches the number of words, we found a valid start index
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // If the word is not part of the word list, reset the window
                    seenWords.clear();
                    count = 0;
                    left = right; // Move left to right
                }
            }
        }

        return result;
  
}
}
