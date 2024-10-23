package leetcode.editor.en;

import java.util.*;

class TextJustification {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> out = new ArrayList<>();
        int size = -1, startIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(size + 1 + word.length() > maxWidth){
                out.add(justifyLine(words, startIndex, i, maxWidth));
                size = word.length();
                startIndex = i;
            } else {
                size += 1 + word.length(); // word plus the space preceding it.
            }
        }
        out.add(connectLine(words, startIndex, words.length, maxWidth));
        return out;
    }

    /** justify a line that consists of words from the input array between the indexes
     *
     * @param words input array
     * @param low start index (inclusive)
     * @param high end index (exclusive)
     * @return left-justified line
     */
    public String justifyLine(String[] words, int low, int high, int maxWidth){
        int wordCount = high - low;
        if(wordCount == 1) return words[low] + " ".repeat(maxWidth - words[low].length());
        int totalSpaceCount = maxWidth;
        for (int i = low; i < high; i++) totalSpaceCount -= words[i].length();
        int standardSpaceNumber = totalSpaceCount / (wordCount - 1);
        int extraSpacesCount = totalSpaceCount % (wordCount - 1);
        StringBuilder sb = new StringBuilder(words[low]);
        for (int i = low + 1; i < high; i++) {
            sb.append(" ".repeat(standardSpaceNumber + (extraSpacesCount > 0 ? 1 : 0)));
            sb.append(words[i]);
            extraSpacesCount--;
        }
        return sb.toString();
    }

    /**
     * Connect the words using single spaces, fill the spliced string with spaces on the right to reach expected width.
     *
     * @param words input array
     * @param low start index (inclusive)
     * @param high end index (exclusive)
     * @param maxWidth expected width.
     * @return spliced string
     */
    public String connectLine(String[] words, int low, int high, int maxWidth){
        StringBuilder sb = new StringBuilder(words[low]);
        int remainingChars = maxWidth - words[low].length();
        for (int i = low + 1; i < high; i++) {
            sb.append(' ').append(words[i]);
            remainingChars -= 1 + words[i].length();
        }
        sb.append(" ".repeat(remainingChars));
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}