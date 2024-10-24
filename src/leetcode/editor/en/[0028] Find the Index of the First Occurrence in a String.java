package leetcode.editor.en;

import java.util.*;

class FindTheIndexOfTheFirstOccurrenceInAString {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length(), nlen = needle.length();
        newPosition:
        for (int i = 0; i < hlen - nlen + 1; i++) {
            for (int j = 0; j < nlen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) continue newPosition;
            }
            return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}