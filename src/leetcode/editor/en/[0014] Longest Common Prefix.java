package leetcode.editor.en;

import java.util.*;

class LongestCommonPrefix {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0 ;; i++) {
            if(i >= strs[0].length()) return strs[0].substring(0, i);
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if(i >= s.length() || c != s.charAt(i)) return s.substring(0, i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}