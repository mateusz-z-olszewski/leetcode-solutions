package leetcode.editor.en;

import java.util.*;

class LengthOfLastWord {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        int lastStartingIndex = 0;
        boolean lastIsSpace = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                lastIsSpace = true;
            } else if (lastIsSpace) {
                lastStartingIndex = i;
                lastIsSpace = false;
            }
        }
        return s.length() - countTrailingSpaces(s) - lastStartingIndex;
    }
    int countTrailingSpaces(String s){
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') count++;
            else break;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}