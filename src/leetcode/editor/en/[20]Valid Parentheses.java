package leetcode.editor.en;

import java.util.*;

public class ValidParentheses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' -> { stack.add(')'); }
                case '[' -> { stack.add(']'); }
                case '{' -> { stack.add('}'); }
                case ')' -> { if(stack.isEmpty() || stack.pop() != ')') return false; }
                case ']' -> { if(stack.isEmpty() || stack.pop() != ']') return false; }
                case '}' -> { if(stack.isEmpty() || stack.pop() != '}') return false; }
            }
        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}