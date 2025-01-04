package leetcode.editor.en;

import java.util.*;

class ScoreOfAString {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scoreOfString(String s) {
        int out = 0;
        for (int i = 1; i < s.length(); i++) {
            out += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}