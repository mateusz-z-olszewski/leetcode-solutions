package leetcode.editor.en;

import java.util.*;

class LongestValidParentheses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * Calculates the length of the longest valid parentheses substring. <br>
     * Explanation: notice that the input string is broken into segments divided by unmatched
     * parentheses (let us call them forsaken), and that they always point away from the change of direction of forsaken
     * items, for example <br>{@code xx)xxxx)))xx)xxxx(xx(xx((}, where xx(...) represents a
     * well-formed substring (naturally only of even length).
     */
    public int longestValidParentheses(String s) {
        int highscore = 0;
        // count down from the right
        int opened = 0, count = 0, lowestRightForsakenIndex = s.length();
        for (int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')') { // opened a possible parentheses pair
                opened++;
            } else if (opened != 0) { // closed a valid parentheses pair
                opened--;
                count += 2;
            } else { // found a forsaken item
                // reset the count (possibly a new highscore) and proceed
                highscore = Math.max(highscore, count);
                count = 0;
                lowestRightForsakenIndex = i;
            }
        }

        // count up from the left until the first forsaken item pointing right
        opened = 0;
        count = 0;
        for (int i = 0; i < lowestRightForsakenIndex; i++) {
            if(s.charAt(i) == '(') { // opened a possible parentheses pair
                opened++;
            } else if (opened != 0) { // closed a valid parentheses pair
                opened--;
                count += 2;
            } else { // found a forsaken item
                // reset the count (possibly a new highscore) and proceed
                highscore = Math.max(highscore, count);
                count = 0;
            }
        }

        // account for the gap between forsaken items with different directions
        highscore = Math.max(highscore, count);

        return highscore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
// (()())) -> 0
// (22)) -> 2
// 6) -> 6