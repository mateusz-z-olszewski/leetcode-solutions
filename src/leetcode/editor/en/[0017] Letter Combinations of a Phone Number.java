package leetcode.editor.en;

import java.util.*;

class LetterCombinationsOfAPhoneNumber {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if("".equals(digits)) return List.of();
        List<String> out = new ArrayList<>();
        addRecursively(out, "", digits);
        return out;
    }
    void addRecursively(List<String> out, String s, String digits){
        if("".equals(digits)){
            out.add(s);
            return;
        }
        char first = digits.charAt(0);
        String remaining = digits.substring(1);
        for(char c : mappings[first - '2']){
            addRecursively(out, s + c, remaining);
        }
    }

    char[][] mappings = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(
            new LetterCombinationsOfAPhoneNumber().new Solution().letterCombinations("23")
        );
    }

}