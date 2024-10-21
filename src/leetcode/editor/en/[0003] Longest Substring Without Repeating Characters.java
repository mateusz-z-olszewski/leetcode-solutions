package leetcode.editor.en;

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] seenAt = new int[128];
        int l = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int r = i - seenAt[c] + 1;
            seenAt[c] = i + 1;

            l = Math.min(r, l + 1);
            max = Math.max(max, l);
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}