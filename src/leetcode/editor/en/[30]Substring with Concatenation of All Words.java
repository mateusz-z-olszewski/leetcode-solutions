package leetcode.editor.en;

import java.util.*;

class SubstringWithConcatenationOfAllWords {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String input, String[] words) {
        int wordLen = words[0].length();
        Set<String> wordset = new HashSet<>(Arrays.asList(words));

        // initialize the sliding windows - one for each index%wordLen value
        SlidingWindow[] slidingWindows = new SlidingWindow[wordLen];
        for (int i = 0; i < wordLen; i++) slidingWindows[i] = new SlidingWindow(words);

        List<Integer> out = new ArrayList<>();

        // find all indices that are a beginning of a valid word from the wordset, counting down
        for (int i = input.length() - wordLen; i >= 0; i--) {
            String s = input.substring(i, i + wordLen);
            // add the word to the sliding window or reset it if there is no match
            SlidingWindow sw = slidingWindows[i % wordLen];
            if(wordset.contains(s)) {
                boolean matches = sw.add(s);
                if(matches) out.add(i);
            } else {
                sw.reset();
            }

        }

        return out;
    }
    static class SlidingWindow {
        private Deque<String> items;
        private final int capacity;
        private final Map<String, Integer> expectedCounts = new HashMap<>();
        private final Map<String, Integer> counts;

        public SlidingWindow(String[] words) {
            capacity = words.length;
            counts = new HashMap<>();
            for (String word : words) {
                expectedCounts.put(word, expectedCounts.getOrDefault(word, 0) + 1);
                counts.put(word, 0);
            }
            items = new ArrayDeque<>(capacity);
        }

        public void reset() {
            items = new ArrayDeque<>(capacity);
            for (String s : expectedCounts.keySet())
                counts.put(s, 0);
        }

        /**
         * Adds a new string with corresponding index to the sliding window, removes the oldest one present.
         * If the gap between indices is larger than allowed, resets itself.
         *
         * @return true if the current window is full and matches the expected count of elements
         */
        public boolean add(String string) {
            if (items.size() < capacity) {
                items.add(string);
                counts.put(string, counts.getOrDefault(string, 0) + 1);
                return items.size() == capacity && isMatching();
            }

            String out = items.removeFirst();
            items.add(string);

            if (!string.equals(out)) {
                counts.put(string, counts.getOrDefault(string, 0) + 1);
                counts.put(out, counts.get(out) - 1);
            }

            return isMatching();
        }

        public boolean isMatching() {
            return counts.equals(expectedCounts);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}