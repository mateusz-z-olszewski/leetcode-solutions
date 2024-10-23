package leetcode.editor.en;

import java.util.*;

class StringToIntegerAtoi {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int myAtoi(String s) {
        int length = s.length(), i = 0, sign = 1;
        long MAX = Integer.MAX_VALUE;

        // skip whitespace
        while (i < length && s.charAt(i) == ' ') i++;

        if(i == length) return 0;
        // handle signs
        if(s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(s.charAt(i) == '+'){
            i++;
        }

        long x = 0;

        char c;
        while(i < length && isDigit(c = s.charAt(i))){
            x = x * 10 + toDigit(c);
            i++;
            if(x >= Integer.MAX_VALUE) break;
        }

        if(sign == 1  && x >= MAX    ) x = MAX;
        if(sign == -1 && x >= MAX + 1) x = MAX + 1;
        return sign * (int) x;
    }

    public boolean isDigit(char c){
        return '0' <= c && c <= '9';
    }
    public int toDigit(char c){
        return c - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}