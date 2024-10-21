package leetcode.editor.en;

import java.util.*;

class LongestPalindromicSubstring {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = s.length(); i > 0; i--) { // i is the length of the substring
            for (int j = 0; j <= len - i; j++) { // j is the beginning of substring
                String substring = findPalindromicSubstring(s, j, j+i);
                if(substring != null) return substring;
            }
        }
        return null;
    }

    String findPalindromicSubstring(String s, int low, int high){
        for (int l = low, h = high - 1; l < h; l++, h--)
            if(s.charAt(l) != s.charAt(h)) return null;
        return s.substring(low, high);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}